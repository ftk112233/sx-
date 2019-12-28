package com.mt.sx.controller;

import com.mt.sx.common.base.CommonResult;
import com.mt.sx.common.enums.ResponseCode;
import com.mt.sx.pojo.SxUser;
import com.mt.sx.service.SxUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
@Api(tags = "用户操作接口")
@RestController
@RequestMapping("/user")
public class SxUserController {
    @Autowired
    SxUserService sxUserService;
@ApiOperation("新增用户")
    @PostMapping("/insert")
    public CommonResult insert(SxUser sxUser){
        try {
            sxUserService.insert(sxUser);
            return CommonResult.success();
        } catch (Exception e) {
            e.printStackTrace();
            return CommonResult.fail(ResponseCode.INSERT_FALSE);
        }

    }
}
