package com.mt.sx.controller;

import com.mt.sx.common.base.CommonResult;
import com.mt.sx.common.enums.ResponseCode;
import com.mt.sx.pojo.SxSpecsWay;
import com.mt.sx.service.SxSpecsWayService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "商品出售形式管理")
@RestController
@RequestMapping("/way")
public class SxSpecsWayController {
    @Autowired
    SxSpecsWayService sxSpecsWayService;

    /**
     * 规格
     * 查询所有出售方式
     *
     * @return
     */
    @ApiOperation("查询所有出售方式")
    @GetMapping("/list")
    public CommonResult<List<SxSpecsWay>> list() {
        return CommonResult.success(sxSpecsWayService.list());
    }

    /**
     * 增加出售方式
     *
     * @param sxSpecsWay
     * @return
     */
    @ApiOperation("增加出售方式")
    @PostMapping("/insert")
    public CommonResult insert(SxSpecsWay sxSpecsWay) {
        if (sxSpecsWayService.insert(sxSpecsWay) == 1) {
            return CommonResult.success();
        }
        return CommonResult.fail(ResponseCode.INSERT_FALSE);
    }

    /**
     * 更新出售方式
     *
     * @param sxSpecsWay
     * @return
     */
    @ApiOperation("更新出售方式")
    @PostMapping("/update")
    public CommonResult update(SxSpecsWay sxSpecsWay) {
        if (sxSpecsWayService.update(sxSpecsWay) == 1) {
            return CommonResult.success();
        }
        return CommonResult.fail(ResponseCode.UPDATE_FALSE);
    }

    /**
     * 删除出售方式
     *
     * @param id
     * @return
     */
    @ApiOperation("删除出售方式")
    @PostMapping("/delete")
    public CommonResult delete(Integer id) {
        if (sxSpecsWayService.delete(id) == 1) {
            return CommonResult.success();
        }
        return CommonResult.fail(ResponseCode.DELETE_FALSE);
    }

    /**
     * 根据出售方式id查询出售方式
     *
     * @param id
     * @return
     */
    @ApiOperation("根据出售方式id查询出售方式")
    @GetMapping("findById")
    public CommonResult<SxSpecsWay> findById(Integer id) {
        return CommonResult.success(sxSpecsWayService.findById(id));
    }

    /**
     * 批量删除
     */
    @ApiOperation("批量删除")
    @PostMapping("/batchDelete")
    public CommonResult batchDelete(@RequestParam("ids") List<Integer> ids) {
        try {
            sxSpecsWayService.batchDelete(ids);
            return CommonResult.success();
        } catch (Exception e) {
            e.printStackTrace();
            return CommonResult.fail(ResponseCode.DELETE_FALSE);
        }

    }
}
