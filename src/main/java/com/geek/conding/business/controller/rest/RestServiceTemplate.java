package com.geek.conding.business.controller.rest;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author 孤
 * @version v1.0
 * @Developers 张耀烽
 * @serviceProvider 四叶草安全(SeClover)
 * @description 发送rest请求工具
 * @date 2020/4/8
 */
@RestController
@RequestMapping("/rest")
@Api(value = "/rest", tags = "发送Rest请求控制器")
public class RestServiceTemplate {

    @Autowired
    private RestTemplate restTemplate;



}
