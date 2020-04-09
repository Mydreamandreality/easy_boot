package com.geek.conding.config.aop;

import com.geek.conding.annotaction.SysLog;
import com.geek.conding.base.async.QueueAsync;
import com.geek.conding.utils.bean.SpringContextHolder;
import com.geek.conding.utils.tools.ToolUtil;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;

/**
 * @Author 张耀烽
 * @Date Created in 2020/3/31 22:10
 * @Version v1.0
 * @Description SysLog日志拦截
 */
@Aspect
@Component
@Order(200)
public class SysLogAop {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * 定义切入点
     */
    @Pointcut(value = "@annotation(com.geek.conding.annotaction.SysLog)")
    public void cutService() {
    }

    @Around("cutService()")
    public Object recordSysLog(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Object result = proceedingJoinPoint.proceed();
        try {
            handle(proceedingJoinPoint);
        } catch (Exception e) {
            logger.error(">>>> Sys日志推送失败: [{}] >>>>> ", e.getMessage());
        }
        return result;
    }

    /**
     * 日志数据队列推送
     * <p>
     * 日志数据记录到数据库
     * <p>
     * 两种方案任意切换，支持任意方式扩展
     *
     * @param proceedingJoinPoint
     */
    private void handle(ProceedingJoinPoint proceedingJoinPoint) throws NoSuchMethodException {
        Signature signature = proceedingJoinPoint.getSignature();

        if (!(signature instanceof MethodSignature)) {
            throw new IllegalArgumentException("该注解只能用于方法");
        }

        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest servletRequest = attributes.getRequest();
        //透过代理获取真实IP
        String ip = ToolUtil.getIPAddress(servletRequest);
        //构建请求URI
        String uri = servletRequest.getRequestURL().append("?").append(servletRequest.getQueryString()).toString();
        //方法名称
        String methodName = signature.getName();

        Method method = ToolUtil.getCurrentMethod(proceedingJoinPoint, signature);
        SysLog sysLog = method.getAnnotation(SysLog.class);
        //日志类型ID保存到RDS
        Integer logTypeId = sysLog.logType().getLogTypeId();

        String logTypeName = sysLog.logType().getLogTypeName();

        String logDesc = sysLog.logContent().getLogContent();

        QueueAsync queueAsync = SpringContextHolder.getBean(QueueAsync.class);
        queueAsync.sendQueueSysLog(ip, uri, methodName, logTypeName, logDesc);
    }
}
