package com.geek.conding.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.geek.conding.model.rds.SysUserDTO;

import java.util.List;

/**
 * @Author 张耀烽
 * @Date Created in 2020/3/31 22:10
 * @Version v1.0
 * @Description user service
 */
public interface SysUserService extends IService<SysUserDTO> {

    /**
     * 获取所有用户
     *
     * @return
     */
    List<SysUserDTO> getUserAll();
}
