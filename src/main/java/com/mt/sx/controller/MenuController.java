package com.mt.sx.controller;

import com.mt.sx.common.base.CommonResult;
import com.mt.sx.common.enums.ResponseCode;
import com.mt.sx.service.SxPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/menu")
public class MenuController {
    @Autowired
    SxPermissionService sxPermissionService;
    /**
     * 加载后台管理左边的菜单
     */
    @GetMapping("/loadLeftMenu")
    public CommonResult loadLeftMenu(){

        try {
            return CommonResult.success(sxPermissionService.loadLeftMenu());
        } catch (Exception e) {
            e.printStackTrace();
            return CommonResult.fail(ResponseCode.FAILED);
        }
    }
}
