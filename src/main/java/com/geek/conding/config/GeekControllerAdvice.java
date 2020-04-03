package com.geek.conding.config;

import com.geek.conding.base.GeekException;
import com.geek.conding.constants.enums.GeekExceptionMsg;
import com.geek.conding.constants.response.RenderResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author 张耀烽
 * @Date Created in 2020/4/3 23:42
 * @Version v1.0
 * @Description 全局异常处理
 */
@ControllerAdvice
public class GeekControllerAdvice {

    @ResponseBody
    @ExceptionHandler(GeekException.class)
    public ResponseEntity<GeekExceptionMsg> geekException(GeekException e, HttpServletRequest request) {
        return RenderResponse.responseErrorMsg(e.getCode(), e.getMessage(), e.getHttpStatus(), e.getRequestId());
    }


    @ResponseBody
    @ExceptionHandler(Exception.class)
    public ResponseEntity<GeekExceptionMsg> sysException(Exception e, HttpServletRequest request) {
        return RenderResponse.responseErrorMsg(GeekExceptionMsg.SERVER_ERROR);
    }
}
