package com.geek.conding.business.controller.geek_client;

import com.geek.conding.business.constants.response.ServiceResult;
import com.geek.conding.business.model.rds.dto.LoginUserDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

/**
 * @Author 张耀烽
 * @Date Created in 2020/3/31 22:10
 * @Version v1.0
 * @Description Login控制器
 */
@RestController
@RequestMapping("/api")
@Api(value = "/api", tags = "geek平台-sys_login接口mock")
public class LoginController {

    @PostMapping(value = "/login")
    @ApiOperation(value = "登录")
    public ServiceResult<String> login(@RequestBody LoginUserDTO loginUser) {
        return null;
    }


    @PostMapping(value = "/register")
    @ApiOperation(value = "注册")
    public ServiceResult<String> register(@RequestBody LoginUserDTO loginUserDTO) {
        return null;
    }


    @PostMapping(value = "/reset")
    @ApiOperation(value = "密码重置")
    public ServiceResult<String> reset(@RequestBody LoginUserDTO loginUserDTO) {
        return null;
    }


    @PostMapping(value = "/logout")
    @ApiOperation(value = "退出登录")
    public ServiceResult<String> logout(@RequestBody LoginUserDTO loginUserDTO) {
        return null;
    }
}
