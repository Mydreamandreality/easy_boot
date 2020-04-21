package com.geek.conding.business.constants.response;

import com.alibaba.fastjson.JSONObject;
import com.geek.conding.business.constants.enums.GeekExceptionMsg;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 * @Author 张耀烽
 * @Date Created in 2020/4/4 0:42
 * @Version v1.0
 * @Description 渲染工具类
 */
public class RenderResponse {

    /**
     * 渲染异常的返回数据
     *
     * @param geekExceptionMsg
     * @return
     */
    public static ResponseEntity responseErrorMsg(GeekExceptionMsg geekExceptionMsg) {
        JSONObject responseJSON = new JSONObject();
        responseJSON.put("errCode", geekExceptionMsg.getCode());
        responseJSON.put("errMsg", geekExceptionMsg.getMessage());
        responseJSON.put("requestId", geekExceptionMsg.getRequestId());
        return new ResponseEntity(responseJSON, geekExceptionMsg.getHttpStatus());
    }


    /**
     * 渲染异常的返回数据
     *
     * @param code
     * @param message
     * @param httpStatus
     * @param requestId
     * @return
     */
    public static ResponseEntity responseErrorMsg(String code, String message, HttpStatus httpStatus, String requestId) {
        JSONObject responseJSON = new JSONObject();
        responseJSON.put("errCode", code);
        responseJSON.put("errMsg", message);
        responseJSON.put("requestId", requestId);
        return new ResponseEntity(responseJSON, httpStatus);
    }
}
