package com.geek.conding.constants.enums;

/**
 * @Author 张耀烽
 * @Date Created in 2020/4/4 0:22
 * @Version v1.0
 * @Description 日志类型常量
 */
public enum LogTypeEnum {

    LOGIN_LOG(1, "登录日志"),

    SERVICE_LOG(2, "操作日志"),

    GET_SERVICE_LOG(3, "访问日志");


    private final Integer logTypeId;

    private final String logTypeName;

    LogTypeEnum(Integer logTypeId, String logTypeName) {
        this.logTypeId = logTypeId;
        this.logTypeName = logTypeName;
    }

    public Integer getLogTypeId() {
        return logTypeId;
    }

    public String getLogTypeName() {
        return logTypeName;
    }
}
