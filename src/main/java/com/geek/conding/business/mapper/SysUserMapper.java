package com.geek.conding.business.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.geek.conding.business.model.rds.SysUserDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author 张耀烽
 * @Date Created in 2020/3/31 22:10
 * @Version v1.0
 * @Description user mapper
 */
@Mapper
public interface SysUserMapper extends BaseMapper<SysUserDTO> {

    /**
     * 获取所有的用户信息
     *
     * @return
     */
    List<SysUserDTO> queryUserAll();


    /**
     * 分页获取所有的用户信息
     *
     * @return
     */
    List<SysUserDTO> queryUserAllByPage();

    /**
     * 新增用户信息
     *
     * @param sysUserDTO
     */
    void addUserInfo(SysUserDTO sysUserDTO);

    /**
     * 删除用户信息
     *
     * @param id
     */
    void delUserInfo(@Param("id") Integer id);

    /**
     * 更新用户信息
     *
     * @param sysUserDTO
     */
    void setUserInfo(SysUserDTO sysUserDTO);


    /**
     * 查看用户订单信息
     *
     * @param id
     * @return
     */
    SysUserDTO queryUserOrderByUserId(@Param("id") Integer id);
}
