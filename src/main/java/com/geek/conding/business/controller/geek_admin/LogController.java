package com.geek.conding.business.controller.geek_admin;

import com.geek.conding.business.constants.response.ServiceResult;
import com.geek.conding.business.model.rds.SysLogDTO;
import com.geek.conding.business.service.impl.SysLogServiceImpl;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author 张耀烽
 * @Date Created in 2020/4/25 0:27
 * @Version v1.0
 * @Description TODO
 */
@RestController
@RequestMapping(value = "/api")
@Api(value = "/api", tags = "geek平台-sys_log接口mock")
public class LogController {

    @Autowired
    private SysLogServiceImpl sysLogService;

    @GetMapping(value = "/logs")
    @ApiOperation(value = "查询所有日志接口", notes = "查询所有日志接口")
    public ServiceResult<PageInfo<SysLogDTO>> queryUserAll(@ApiParam(value = "page_num") @RequestParam(value = "page_num") Integer pageNum,
                                                           @ApiParam(value = "page_size") @RequestParam(value = "page_size") Integer pageSize) {
        PageInfo<SysLogDTO> logDTOS = sysLogService.querySysLogAll(pageNum, pageSize);
        return ServiceResult.success(logDTOS);
    }
}
