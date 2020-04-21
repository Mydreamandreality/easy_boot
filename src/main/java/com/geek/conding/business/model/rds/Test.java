package com.geek.conding.business.model.rds;

/**
 * @author 孤
 * @version v1.0
 * @Developers 张耀烽
 * @serviceProvider 四叶草安全(SeClover)
 * @description 请简易描述定义
 * @date 2020/4/21
 */
public class Test {
    /**
     * data :
     * status : 0
     * error_msg : 认证失败
     */

    private String data;
    private int status;
    private String error_msg;

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getError_msg() {
        return error_msg;
    }

    public void setError_msg(String error_msg) {
        this.error_msg = error_msg;
    }
}
