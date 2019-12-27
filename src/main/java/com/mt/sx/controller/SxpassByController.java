package com.mt.sx.controller;

import com.mt.sx.common.base.CommonResult;
import com.mt.sx.pojo.SxBusiness;
import com.mt.sx.pojo.SxPassby;
import com.mt.sx.service.SxpassbyService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags = "派送员操作接口")
@RestController
@RequestMapping("/passBy")
public class SxpassByController {
    @Autowired
    SxpassbyService sxpassbyService;

    @ApiOperation(value = "查看所有的快递员信息", notes = "根据店家id或者管理员查询，不需要传参数直接获取redis中的参数查询")
    @GetMapping("/findByBusinessId")//根据店家id或者管理员不需要传参数直接查询
    public CommonResult findByBusinessId() {
        return CommonResult.success(sxpassbyService.findByBusId());
    }

    @ApiOperation("插入新的派送员信息")
    @PostMapping("/insert")
    public CommonResult insert(SxPassby sxPassby) {
        return CommonResult.success(sxpassbyService.insert(sxPassby));
    }

    @ApiOperation("更新派送员信息")
    @PostMapping("/update")
    public CommonResult update(SxPassby sxPassby) {
        return CommonResult.success(sxpassbyService.update(sxPassby));
    }

    @ApiOperation(value = "伪删除快递员信息", notes = "不能真删除，订单的显示信息中所有的操作都是调用这里的信息，只能伪删除，否则会造成查询历史订单中派送员消息中数据为空")
    @PostMapping("/deleted")
    public CommonResult deleted(SxPassby sxPassby) {
        return CommonResult.success(sxpassbyService.update(sxPassby));
    }

}
