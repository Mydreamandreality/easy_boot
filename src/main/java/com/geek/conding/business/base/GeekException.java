package com.geek.conding.business.base;

import com.geek.conding.business.constants.enums.GeekExceptionMsg;
import org.springframework.http.HttpStatus;

/**
 * @Author 张耀烽
 * @Date Created in 2020/4/4 0:05
 * @Version v1.0
 * @Description 项目异常
 */
public class GeekException extends RuntimeException {

    private static final long serialVersionUID = -7907257104287193464L;

    private String code;

    private String message;

    private HttpStatus httpStatus;

    private String requestId;

    public GeekException(GeekExceptionMsg geekExceptionEnum) {
        this.code = geekExceptionEnum.getCode();
        this.message = geekExceptionEnum.getMessage();
        this.httpStatus = geekExceptionEnum.getHttpStatus();
        this.requestId = geekExceptionEnum.getRequestId();
    }

    @Override
    public String getMessage() {
        return message;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }
}
