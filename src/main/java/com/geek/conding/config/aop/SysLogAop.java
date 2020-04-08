package com.geek.conding.config.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

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
    private void handle(ProceedingJoinPoint proceedingJoinPoint) {

    }
}
