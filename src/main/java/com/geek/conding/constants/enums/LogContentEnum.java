package com.geek.conding.constants.enums;

/**
 * @Author 张耀烽
 * @Date Created in 2020/4/4 0:22
 * @Version v1.0
 * @Description 日志内容常量
 */
public enum LogContentEnum {

    /*资源查看*/
    GET_INDEX("资源查看", "查看系统服务基础数据"),

    GET_USERS("资源查看", "查看所有用户信息");


    private final String logTitle;

    private final String logDesc;

    LogContentEnum(String logTitle, String logDesc) {
        this.logTitle = logTitle;
        this.logDesc = logDesc;
    }

    public String getLogTitle() {
        return logTitle;
    }

    public String getLogDesc() {
        return logDesc;
    }

    public String getLogContent() {
        return "日志标题:" + logTitle + ",日志内容:" + logDesc;
    }
}
