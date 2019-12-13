package com.mt.sx.controller;

import com.mt.sx.common.base.CommonResult;
import com.mt.sx.pojo.SxBusiness;
import com.mt.sx.pojo.SxPassby;
import com.mt.sx.service.SxpassbyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/passby")
public class SxpassbyController {
    @Autowired
    SxpassbyService sxpassbyService;

    @GetMapping("/findByBusId")//根据店家id或者管理员不需要传参数直接查询
    public CommonResult findByBusId( Integer Businessid){
        return  CommonResult.success(sxpassbyService.findByBusId(Businessid));
    }
    @PostMapping("/insert")
    public CommonResult insert(SxPassby sxPassby){
        return CommonResult.success(sxpassbyService.insert(sxPassby));
    }

    @PostMapping("/insert")
    public CommonResult update(SxPassby sxPassby){
        return CommonResult.success(sxpassbyService.update(sxPassby));
    }

    @PostMapping("/deleted")
    public CommonResult deleted(Integer passId){
        return CommonResult.success(sxpassbyService.deleted(passId));
    }

}
