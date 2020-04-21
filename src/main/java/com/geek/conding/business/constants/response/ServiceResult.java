package com.geek.conding.business.constants.response;

import java.io.Serializable;

/**
 * @Author 张耀烽
 * @Date Created in 2020/4/2 23:01
 * @Version v1.0
 * @Description Service
 */
public class ServiceResult<T> implements Serializable {

    private static final long serialVersionUID = 3871677341680489494L;

    private boolean success = false;

    private String code;

    private String message;

    private T result;

    private ServiceResult() {
    }

    public static <T> ServiceResult<T> success(T result) {
        ServiceResult<T> item = new ServiceResult<T>();
        item.success = true;
        item.result = result;
        item.code = "200";
        item.message = "success";
        return item;
    }

    public static <T> ServiceResult<T> failure(String errorCode, String errorMessage) {
        ServiceResult<T> item = new ServiceResult<T>();
        item.success = false;
        item.code = errorCode;
        item.message = errorMessage;
        return item;
    }

    public static <T> ServiceResult<T> failure(String errorCode) {
        ServiceResult<T> item = new ServiceResult<T>();
        item.success = false;
        item.code = errorCode;
        item.message = "failure";
        return item;
    }

    public boolean hasResult() {
        return result != null;
    }

    public boolean isSuccess() {
        return success;
    }

    public T getResult() {
        return result;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
