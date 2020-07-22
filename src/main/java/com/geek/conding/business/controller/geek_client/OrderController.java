package com.geek.conding.business.controller.geek_client;

import com.geek.conding.business.constants.response.ServiceResult;
import com.geek.conding.business.model.rds.SysOrderDTO;
import com.geek.conding.business.model.rds.SysUserDTO;
import com.geek.conding.business.service.impl.SysUserServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author 张耀烽
 * @Date Created in 2020/3/31 22:10
 * @Version v1.0
 * @Description Order控制器
 */
@RestController
@RequestMapping("/api")
@Api(value = "/api", tags = "geek平台-sys_order接口mock")
public class OrderController<T> {

    @Autowired
    private SysUserServiceImpl sysUserService;

    @GetMapping(value = "/order")
    @ApiOperation(value = "查询指定用户的订单信息")
    public ServiceResult<SysUserDTO> getUserInOrderInfo(@RequestParam("id") Integer id) {
        SysUserDTO sysUserDTO = sysUserService.queryUserOrderByUserId(id);
        return ServiceResult.success(sysUserDTO);
    }

    @GetMapping(value = "/order/{id}")
    @ApiOperation(value = "查询指定订单的详细信息")
    public ServiceResult<SysOrderDTO> getOrderInfo(@PathVariable(value = "id") Integer id) {
        return null;
    }

    @PostMapping(value = "/order")
    @ApiOperation(value = "创建订单")
    public ServiceResult<String> addOrder(@RequestBody SysOrderDTO sysOrderDTO) {
        return null;
    }

    @DeleteMapping(value = "/order")
    @ApiOperation(value = "删除当前用户产生的订单")
    public ServiceResult<String> delOrder(@RequestBody SysOrderDTO sysOrderDTO) {
        return null;
    }
}
