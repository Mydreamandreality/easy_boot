package com.geek.conding.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.geek.conding.mapper.SysUserMapper;
import com.geek.conding.model.rds.SysUserDTO;
import com.geek.conding.service.SysUserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author 张耀烽
 * @Date Created in 2020/3/31 22:10
 * @Version v1.0
 * @Description user impl
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUserDTO> implements SysUserService {

    @Override
    @Cacheable(value = "geek", key = "'users'", unless = "#result == null")
    public List<SysUserDTO> queryUserAll() {
        return baseMapper.queryUserAll();
    }

    @Override
    public PageInfo<SysUserDTO> queryUserAllByPage(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<SysUserDTO> dtoList = baseMapper.queryUserAllByPage();
        PageInfo<SysUserDTO> userDTOPageInfo = new PageInfo<>(dtoList);
        return userDTOPageInfo;
    }
}
