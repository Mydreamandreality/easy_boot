package com.geek.conding.annotaction;

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
    String logType();

    /**
     * 日志内容
     *
     * @return
     */
    String logContent();
}
