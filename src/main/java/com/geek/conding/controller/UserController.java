package com.geek.conding.controller;

import com.geek.conding.model.rds.UserDTO;
import com.geek.conding.service.impl.SysUserServiceImpl;
import com.geek.conding.constants.response.ServiceResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author 张耀烽
 * @Date Created in 2020/3/31 22:10
 * @Version v1.0
 * @Description user接口
 */
@RestController
@RequestMapping(value = "/api")
public class UserController {

    @Autowired
    private SysUserServiceImpl sysUserService;

    @GetMapping(value = "/users")
    public ServiceResult<List<UserDTO>> getUserAll() {
        List<UserDTO> userDTOS = sysUserService.getUserAll();
        return ServiceResult.success(userDTOS);
    }
}
