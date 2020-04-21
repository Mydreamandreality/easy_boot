package com.geek.conding.business.controller.mock;

import com.geek.conding.business.constants.RedisChannelConstants;
import com.geek.conding.business.constants.response.ServiceResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


/**
 * @Author 张耀烽
 * @Date Created in 2020/4/21 22:10
 * @Version v1.0
 * @Description user接口
 */
@RestController
@RequestMapping(value = "/api")
@Api(value = "/mock", tags = "geek平台-中间件功能Mock")
public class MockController {

    @Autowired
    private RedisTemplate redisTemplate;

    @GetMapping(value = "/pub/channel")
    @ApiOperation(value = "消息发布Mock", notes = "消息发布后检查控制台是否有监听日志")
    public ServiceResult pubChannel(@ApiParam(value = "消息内容") @RequestParam(value = "message") String message) {
        redisTemplate.convertAndSend(RedisChannelConstants.mock_channel, message);
        return ServiceResult.success(HttpStatus.OK);
    }

}
