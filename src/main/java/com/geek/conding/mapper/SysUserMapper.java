package com.geek.conding.mapper;

import com.geek.conding.model.UserDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SysUserMapper {

    /**
     * 获取所有的用户信息
     *
     * @return
     */
    List<UserDTO> getUserAll();
}
