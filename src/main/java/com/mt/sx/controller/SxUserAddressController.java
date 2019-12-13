package com.mt.sx.controller;

import com.mt.sx.common.base.CommonResult;
import com.mt.sx.common.enums.ResponseCode;
import com.mt.sx.pojo.SxAddressInfo;
import com.mt.sx.pojo.SxSpu;
import com.mt.sx.service.SxUserAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/address")
public class SxUserAddressController {
    @Autowired
    SxUserAddressService sxUserAddressService;

    @GetMapping("/list")
    public CommonResult addressList(Integer shopId){
        return CommonResult.success(sxUserAddressService.addressList(shopId));
    }

    @PostMapping("/insert")
    public CommonResult insert(SxAddressInfo sxAddressInfo){
        if(sxUserAddressService.insert(sxAddressInfo)==1){
            return CommonResult.success();
        }
        return CommonResult.fail(ResponseCode.INSERT_FALSE);
    }
    @PostMapping("/update")
    public CommonResult update(SxAddressInfo sxAddressInfo){
        if(sxUserAddressService.update(sxAddressInfo)==1){
            return CommonResult.success();
        }
        return CommonResult.fail(ResponseCode.INSERT_FALSE);
    }
    @PostMapping("/deletedForUser")
    public CommonResult delete(Integer id){
        if(id!=null){
            return CommonResult.success(sxUserAddressService.deletedForUser(id));
        }
        return CommonResult.fail(ResponseCode.DELETE_FALSE);
    }

}
