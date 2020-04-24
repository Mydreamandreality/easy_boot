package com.geek.conding.business.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.geek.conding.business.model.rds.SysLogDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author 张耀烽
 * @Date Created in 2020/4/25 0:17
 * @Version v1.0
 * @Description sys log mapper
 */
@Mapper
public interface SysLogMapper extends BaseMapper<SysLogDTO> {

    /**
     * 查询所有日志数据
     *
     * @return
     */
    List<SysLogDTO> querySysLogAll();
}
