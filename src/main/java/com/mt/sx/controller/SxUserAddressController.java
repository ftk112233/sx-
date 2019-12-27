package com.mt.sx.controller;

import com.mt.sx.common.base.CommonResult;
import com.mt.sx.common.enums.ResponseCode;
import com.mt.sx.pojo.SxAddressInfo;
import com.mt.sx.pojo.SxSpu;
import com.mt.sx.service.SxUserAddressService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(tags = "买家地址管理接口")
@RestController
@RequestMapping("/address")
public class SxUserAddressController {
    @Autowired
    SxUserAddressService sxUserAddressService;

    @ApiOperation("买家地址信息列表展示")
    @GetMapping("/list")
    public CommonResult addressList() {
        return CommonResult.success(sxUserAddressService.addressList());
    }

    @ApiOperation("买家新增地址")
    @PostMapping("/insert")
    public CommonResult insert(SxAddressInfo sxAddressInfo) {
        if (sxUserAddressService.insert(sxAddressInfo) == 1) {
            return CommonResult.success();
        }
        return CommonResult.fail(ResponseCode.INSERT_FALSE);
    }

    @ApiOperation("买家更新地址")
    @PostMapping("/update")
    public CommonResult update(SxAddressInfo sxAddressInfo) {
        if (sxUserAddressService.update(sxAddressInfo) == 1) {
            return CommonResult.success();
        }
        return CommonResult.fail(ResponseCode.INSERT_FALSE);
    }

    @ApiOperation("买家删除地址")
    @PostMapping("/deletedForUser")
    public CommonResult delete(Integer id) {
        if (id != null) {
            return CommonResult.success(sxUserAddressService.deletedForUser(id));
        }
        return CommonResult.fail(ResponseCode.DELETE_FALSE);
    }

}
