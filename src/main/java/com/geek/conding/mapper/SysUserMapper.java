package com.geek.conding.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.geek.conding.model.rds.SysUserDTO;
import org.apache.ibatis.annotations.Mapper;

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
    List<SysUserDTO> getUserAll();
}
