package com.geek.conding.business.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.geek.conding.business.model.rds.SysUserDTO;
import com.github.pagehelper.PageInfo;

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
    List<SysUserDTO> queryUserAll();

    /**
     * 分页获取所有用户
     *
     * @param pageSize 页数
     * @param pageNum  页量
     * @return
     */
    PageInfo<SysUserDTO> queryUserAllByPage(Integer pageNum, Integer pageSize);
}
