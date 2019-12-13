package com.mt.sx.controller;

import com.mt.sx.common.base.CommonResult;
import com.mt.sx.common.enums.ResponseCode;
import com.mt.sx.pojo.SxSpecsWay;
import com.mt.sx.service.SxSpecsWayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/way")
public class SxSpecsWayController {
    @Autowired
    SxSpecsWayService sxSpecsWayService;

    /**
     * 规格
     * 查询所有出售方式
     * @return
     */
    @GetMapping("/list")
    public CommonResult<List<SxSpecsWay>> list(){
        return CommonResult.success(sxSpecsWayService.list());
    }

    /**
     * 增加出售方式
     * @param sxSpecsWay
     * @return
     */
    @PostMapping("/insert")
    public CommonResult insert(SxSpecsWay sxSpecsWay){
        if(sxSpecsWayService.insert(sxSpecsWay)==1){
            return CommonResult.success();
        }
        return CommonResult.fail(ResponseCode.INSERT_FALSE);
    }

    /**
     * 更新出售方式
     * @param sxSpecsWay
     * @return
     */
    @PostMapping("/update")
    public CommonResult update(SxSpecsWay sxSpecsWay){
        if(sxSpecsWayService.update(sxSpecsWay)==1){
            return CommonResult.success();
        }
        return CommonResult.fail(ResponseCode.UPDATE_FALSE);
    }

    /**
     * 删除出售方式
     * @param id
     * @return
     */
    @PostMapping("/delete")
    public CommonResult delete(Integer id){
        if(sxSpecsWayService.delete(id)==1){
            return CommonResult.success();
        }
        return CommonResult.fail(ResponseCode.DELETE_FALSE);
    }

    /**
     * 根据出售方式id查询出售方式
     * @param id
     * @return
     */
    @GetMapping("findById")
    public CommonResult<SxSpecsWay> findById(Integer id){
        return CommonResult.success(sxSpecsWayService.findById(id));
    }
}
