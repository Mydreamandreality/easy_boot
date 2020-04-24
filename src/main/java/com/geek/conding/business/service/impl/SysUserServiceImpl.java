package com.geek.conding.business.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.geek.conding.business.base.GeekException;
import com.geek.conding.business.constants.enums.GeekExceptionMsg;
import com.geek.conding.business.mapper.SysUserMapper;
import com.geek.conding.business.model.rds.SysUserDTO;
import com.geek.conding.business.service.SysUserService;
import com.geek.conding.utils.tools.ToolUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.cache.annotation.CacheEvict;
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

    @Override
    public void addUserInfo(SysUserDTO sysUserDTO) {
        if (ToolUtil.isEmpty(sysUserDTO)) {
            throw new GeekException(GeekExceptionMsg.BAD_REQUEST_ERROR);
        }
        baseMapper.addUserInfo(sysUserDTO);
    }

    @Override
    @CacheEvict(value = "geek", key = "'users'")
    public void delUserInfo(Integer id) {
        if (ToolUtil.isEmpty(id)) {
            throw new GeekException(GeekExceptionMsg.BAD_REQUEST_ERROR);
        }
        baseMapper.delUserInfo(id);
    }

    @Override
    @CacheEvict(value = "geek", key = "'users'")
    public void setUserInfo(SysUserDTO sysUserDTO) {
        if (ToolUtil.isEmpty(sysUserDTO)) {
            throw new GeekException(GeekExceptionMsg.BAD_REQUEST_ERROR);
        }
        baseMapper.setUserInfo(sysUserDTO);
    }
}
