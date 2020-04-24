package com.geek.conding.business.controller;

import com.geek.conding.business.model.rds.SysUserDTO;
import com.geek.conding.business.service.impl.SysUserServiceImpl;
import com.geek.conding.business.constants.response.ServiceResult;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author 张耀烽
 * @Date Created in 2020/3/31 22:10
 * @Version v1.0
 * @Description user接口
 */
@RestController
@RequestMapping(value = "/api")
@Api(value = "/api", tags = "geek平台-sys_user接口mock")
public class UserController {

    @Autowired
    private SysUserServiceImpl sysUserService;

    @GetMapping(value = "/users")
    @ApiOperation(value = "查询所有用户接口", notes = "查询所有用户接口")
    public ServiceResult<List<SysUserDTO>> queryUserAll() {
        List<SysUserDTO> userDTOS = sysUserService.queryUserAll();
        return ServiceResult.success(userDTOS);
    }


    @GetMapping(value = "/page/users")
    @ApiOperation(value = "分页查询所有用户接口", notes = "分页查询所有用户接口")
    public ServiceResult<PageInfo<SysUserDTO>> queryUserAllByPage(@ApiParam(value = "page_num") @RequestParam(value = "page_num") Integer pageNum,
                                                                  @ApiParam(value = "page_size") @RequestParam(value = "page_size") Integer pageSize) {
        PageInfo<SysUserDTO> userDTOIPage = sysUserService.queryUserAllByPage(pageNum, pageSize);
        return ServiceResult.success(userDTOIPage);
    }

    @PostMapping(value = "/user")
    @ApiOperation(value = "新增用户信息", notes = "新增用户信息")
    public ServiceResult<String> queryUserAll(@RequestBody SysUserDTO sysUserDTO) {
        sysUserService.addUserInfo(sysUserDTO);
        return ServiceResult.success("新增用户信息成功");
    }


    @PutMapping(value = "/user")
    @ApiOperation(value = "更新用户信息", notes = "更新用户信息")
    public ServiceResult<String> setUserInfo(@RequestBody SysUserDTO sysUserDTO) {
        sysUserService.setUserInfo(sysUserDTO);
        return ServiceResult.success("更新用户信息成功");
    }


    @DeleteMapping(value = "/user/{id}")
    @ApiOperation(value = "删除指定用户信息", notes = "查询所有用户接口")
    public ServiceResult<String> queryUserAll(@PathVariable("id") Integer id) {
        sysUserService.delUserInfo(id);
        return ServiceResult.success("用户信息id {" + id + "} 删除成功");
    }
}
