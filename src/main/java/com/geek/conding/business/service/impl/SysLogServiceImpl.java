package com.geek.conding.business.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.geek.conding.business.mapper.SysLogMapper;
import com.geek.conding.business.model.rds.SysLogDTO;
import com.geek.conding.business.model.rds.SysUserDTO;
import com.geek.conding.business.service.SysLogService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author 张耀烽
 * @Date Created in 2020/4/25 0:26
 * @Version v1.0
 * @Description sys log service
 */
@Service
public class SysLogServiceImpl extends ServiceImpl<SysLogMapper, SysLogDTO> implements SysLogService {

    @Override
    public PageInfo<SysLogDTO> querySysLogAll(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<SysLogDTO> dtoList = baseMapper.querySysLogAll();
        PageInfo<SysLogDTO> userDTOPageInfo = new PageInfo<>(dtoList);
        return userDTOPageInfo;
    }
}
