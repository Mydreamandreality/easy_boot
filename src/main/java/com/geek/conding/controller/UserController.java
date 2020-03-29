package com.geek.conding.controller;

import com.geek.conding.model.UserDTO;
import com.geek.conding.service.SysUserService;
import com.geek.conding.service.impl.SysUserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class UserController {

    @Autowired
    private SysUserServiceImpl sysUserService;

    @GetMapping(value = "/users")
    public List<UserDTO> getUserAll() {
        return sysUserService.getUserAll();
    }
}
