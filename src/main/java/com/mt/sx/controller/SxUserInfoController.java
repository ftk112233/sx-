package com.mt.sx.controller;

import com.mt.sx.common.base.CommonResult;
import com.mt.sx.service.SxUserAddressService;
import com.mt.sx.service.SxUserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/userInfo")
public class SxUserInfoController {
    @Autowired
    SxUserInfoService sxUserInfoService;

    @GetMapping("/select")
    public CommonResult selectUser(Integer id){
        return CommonResult.success(sxUserInfoService.selectUser(id));
    }
}
