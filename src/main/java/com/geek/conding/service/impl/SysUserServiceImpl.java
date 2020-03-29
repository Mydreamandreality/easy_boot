package com.geek.conding.service.impl;

import com.geek.conding.mapper.SysUserMapper;
import com.geek.conding.model.UserDTO;
import com.geek.conding.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SysUserServiceImpl implements SysUserService {

    @Autowired
    private SysUserMapper sysUserMapper;

    @Override
    @Cacheable(value = "geek", key = "'users'", unless = "#result == null")
    public List<UserDTO> getUserAll() {
        return sysUserMapper.getUserAll();
    }
}
