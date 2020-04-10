package com.geek.conding.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.geek.conding.mapper.SysUserMapper;
import com.geek.conding.model.rds.SysUserDTO;
import com.geek.conding.service.SysUserService;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author 张耀烽
 * @Date Created in 2020/3/31 22:10
 * @Version v1.0
 * @Description user impl
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUserDTO> implements SysUserService {

    @Override
    @Cacheable(value = "geek", key = "'users'", unless = "#result == null")
    public List<SysUserDTO> getUserAll() {
        return baseMapper.getUserAll();
    }
}
