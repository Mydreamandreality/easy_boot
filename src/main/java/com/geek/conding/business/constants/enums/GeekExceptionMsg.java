package com.geek.conding.business.constants.enums;

import com.geek.conding.utils.SnowFlake;
import org.springframework.http.HttpStatus;

/**
 * @Author 张耀烽
 * @Date Created in 2020/4/4 0:22
 * @Version v1.0
 * @Description 返回的具体异常信息
 */
public enum GeekExceptionMsg {

    SERVER_ERROR("InternalServerError", "InternalServerError", HttpStatus.INTERNAL_SERVER_ERROR, SnowFlake.nextId()),

    SERVICE_ERROR("ServiceError", "ServiceErrorMsg", HttpStatus.BAD_REQUEST, SnowFlake.nextId()),

    ES_INIT_ERROR("EsInitError", "InitIoError", HttpStatus.INTERNAL_SERVER_ERROR, SnowFlake.nextId()),

    BAD_REQUEST_ERROR("RequestError", "RequestParamError", HttpStatus.BAD_REQUEST, SnowFlake.nextId());

    private String code;

    private String message;

    private HttpStatus httpStatus;

    private String requestId;

    GeekExceptionMsg(String code, String message, HttpStatus httpStatus, String requestId) {
        this.code = code;
        this.message = message;
        this.httpStatus = httpStatus;
        this.requestId = requestId;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public String getRequestId() {
        return requestId;
    }
}
