package com.mt.sx.controller;

import com.mt.sx.common.base.CommonResult;
import com.mt.sx.service.SxUserAddressService;
import com.mt.sx.service.SxUserInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@Api(tags = "用户详细信息接口")
@RestController
@RequestMapping("/userInfo")
public class SxUserInfoController {
    @Autowired
    SxUserInfoService sxUserInfoService;
     @ApiOperation("管理员查询用户详细信息接口")
    @GetMapping("/select")
    public CommonResult selectUser(Integer id){
        return CommonResult.success(sxUserInfoService.selectUser(id));
    }
}
