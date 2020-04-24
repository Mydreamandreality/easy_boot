package com.geek.conding.business.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.geek.conding.business.model.rds.SysLogDTO;
import com.github.pagehelper.PageInfo;

/**
 * @Author 张耀烽
 * @Date Created in 2020/4/25 0:25
 * @Version v1.0
 * @Description TODO
 */
public interface SysLogService extends IService<SysLogDTO> {

    /**
     * 查询所有日志数据
     *
     * @return
     */
    PageInfo<SysLogDTO> querySysLogAll(Integer pageNum, Integer pageSize);
}
