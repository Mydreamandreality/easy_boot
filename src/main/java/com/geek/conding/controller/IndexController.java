package com.geek.conding.controller;

import com.geek.conding.constants.ApplicationConstants;
import com.geek.conding.constants.response.ServiceResult;
import com.geek.conding.utils.bean.ApplicationHolder;
import com.google.common.collect.ImmutableMap;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.Properties;

/**
 * @Author 张耀烽
 * @Date Created in 2020/3/31 22:10
 * @Version v1.0
 * @Description 程序自检
 */
@RestController
@RequestMapping(value = "/index")
@Api(value = "/api", tags = "程序自检入口")
@Slf4j
public class IndexController {

    @GetMapping(value = "/hello/{name}")
    @ApiOperation(value = "服务信息接口", notes = "提供服务基础数据")
    public ServiceResult Index(@PathVariable("name") String name) {
        Properties serverPro = ApplicationHolder.getApplication(ApplicationConstants.application);

        ImmutableMap<String, String> serverMap = ImmutableMap.<String, String>builder()
                .put("version", serverPro.getProperty("version"))
                .put("commit-hash", serverPro.getProperty("commit-hash"))
                .put("init-time", serverPro.getProperty("init-time"))
                .put("limiting", serverPro.getProperty("limiting"))
                .build();

        log.info("你好，{}: 欢迎访问Geek项目!", name);

        return ServiceResult.success(serverMap);
    }
}
