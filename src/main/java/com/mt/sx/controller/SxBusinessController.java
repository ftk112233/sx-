package com.mt.sx.controller;

import com.mt.sx.common.base.CommonResult;
import com.mt.sx.common.enums.ResponseCode;
import com.mt.sx.pojo.SxBusiness;
import com.mt.sx.service.SxBusinessService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "商城卖家操作接口")
@RestController
@RequestMapping("/business")
public class SxBusinessController {
    @Autowired
    SxBusinessService sxBusinessService;

    /**
     * 查询所有商户
     *
     * @param sxBusiness
     * @return
     */
    @ApiOperation(value = "查询所有的商户")
    @GetMapping("/list")
    public CommonResult<List<SxBusiness>> list(SxBusiness sxBusiness) {
        return CommonResult.success(sxBusinessService.list(sxBusiness));
    }

    /**
     * 根据id查询商户
     *
     * @param id
     * @return
     */
    @ApiOperation(value = "根据id查询商户")
    @GetMapping("/findById")
    public CommonResult<SxBusiness> findById(@RequestParam("id") Integer id) {
        return CommonResult.success(sxBusinessService.findById(id));
    }

    /**
     * 更新商户
     *
     * @param sxBusiness
     * @return
     */
    @ApiOperation(value = "更新商户")
    @PostMapping("/update")
    public CommonResult update(SxBusiness sxBusiness) {
        try {
            sxBusinessService.update(sxBusiness);
            return CommonResult.success();
        } catch (Exception e) {
            e.printStackTrace();
            return CommonResult.fail(ResponseCode.UPDATE_FALSE);
        }
    }

    /**
     * 增加商户
     *
     * @param sxBusiness
     * @return
     */
    @ApiOperation(value = "增加商户")
    @PostMapping("/insert")
    public CommonResult insert(SxBusiness sxBusiness) {
        try {
            sxBusinessService.insert(sxBusiness);
            return CommonResult.success();
        } catch (Exception e) {
            e.printStackTrace();
            return CommonResult.fail(ResponseCode.INSERT_FALSE);
        }
    }

    /**
     * 删除
     *
     * @param id
     * @return
     */
    @ApiOperation("删除商户")
    @PostMapping("/delete")
    public CommonResult delete(Integer id) {
        try {
            sxBusinessService.delete(id);
            return CommonResult.success();
        } catch (Exception e) {
            e.printStackTrace();
            return CommonResult.fail(ResponseCode.DELETE_FALSE);
        }
    }

    /**
     * 批量删除
     *
     * @param ids
     * @return
     */
    @ApiOperation("批量删除商家")
    @PostMapping("/batchDelete")
    public CommonResult batchDelete(@RequestParam("ids") List<Integer> ids) {
        try {
            sxBusinessService.batchDelete(ids);
            return CommonResult.success();
        } catch (Exception e) {
            e.printStackTrace();
            return CommonResult.fail(ResponseCode.DELETE_FALSE);
        }
    }
}
