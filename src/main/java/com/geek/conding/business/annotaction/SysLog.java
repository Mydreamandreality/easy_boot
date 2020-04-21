package com.geek.conding.business.annotaction;

import com.geek.conding.business.constants.enums.LogContentEnum;
import com.geek.conding.business.constants.enums.LogTypeEnum;

import java.lang.annotation.*;

/**
 * @Author 张耀烽
 * @Date Created in 2020/3/31 22:10
 * @Version v1.0
 * @Description SysLog
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface SysLog {

    /**
     * 日志类型
     *
     * @return
     */
    LogTypeEnum logType() default LogTypeEnum.SERVICE_LOG;

    /**
     * 日志内容
     *
     * @return
     */
    LogContentEnum logContent();
}
