package com.mt.sx.controller;

import com.mt.sx.common.base.CommonResult;
import com.mt.sx.common.enums.ResponseCode;
import com.mt.sx.pojo.SxBusiness;
import com.mt.sx.service.SxBusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/business")
public class SxBusinessController {
    @Autowired
    SxBusinessService sxBusinessService;

    @GetMapping("/list")
    public CommonResult<List<SxBusiness>> list(SxBusiness sxBusiness){
       return CommonResult.success( sxBusinessService.list(sxBusiness));
    }

    @GetMapping("/findById")
    public CommonResult<SxBusiness> findById(@RequestParam("id") Integer id){
        return  CommonResult.success(sxBusinessService.findById(id));
    }

    @PostMapping("/update")
    public CommonResult update(SxBusiness sxBusiness){
        try {
            sxBusinessService.update(sxBusiness);
            return CommonResult.success();
        } catch (Exception e) {
            e.printStackTrace();
            return CommonResult.fail(ResponseCode.UPDATE_FALSE);
        }
    }

    @PostMapping("/insert")
    public CommonResult insert(SxBusiness sxBusiness){
        try {
            sxBusinessService.insert(sxBusiness);
            return CommonResult.success();
        } catch (Exception e) {
            e.printStackTrace();
            return CommonResult.fail(ResponseCode.INSERT_FALSE);
        }
    }

    @PostMapping("/delete")
    public CommonResult delete(Integer id){
      return  null;
    }
}
