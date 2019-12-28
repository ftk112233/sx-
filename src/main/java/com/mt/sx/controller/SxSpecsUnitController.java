package com.mt.sx.controller;

import com.mt.sx.common.base.CommonResult;
import com.mt.sx.common.enums.ResponseCode;
import com.mt.sx.pojo.SxSpecsUnit;
import com.mt.sx.service.SxSpecsUnitService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "商品规格管理")
@RestController
@RequestMapping("/unit")
public class SxSpecsUnitController {
    @Autowired
    SxSpecsUnitService sxSpecsUnitService;

    /**
     * 查询所有规格单位
     *
     * @return
     */
    @ApiOperation("查询所有规格单位")
    @GetMapping("/list")
    public CommonResult<List<SxSpecsUnit>> list() {
        return CommonResult.success(sxSpecsUnitService.list());
    }

    /**
     * 增加规格单位
     *
     * @param sxSpecsUnit
     * @return
     */
    @ApiOperation("增加规格单位")
    @PostMapping("/insert")
    public CommonResult insert(SxSpecsUnit sxSpecsUnit) {
        if (sxSpecsUnitService.insert(sxSpecsUnit) == 1) {
            return CommonResult.success();
        }
        return CommonResult.fail(ResponseCode.INSERT_FALSE);
    }

    /**
     * 更新规格单位
     *
     * @param sxSpecsUnit
     * @return
     */
    @ApiOperation("更新规格单位")
    @PostMapping("/update")
    public CommonResult update(SxSpecsUnit sxSpecsUnit) {
        if (sxSpecsUnitService.update(sxSpecsUnit) == 1) {
            return CommonResult.success();
        }
        return CommonResult.fail(ResponseCode.UPDATE_FALSE);
    }

    /**
     * 删除规格单位
     *
     * @param id 规格单位id
     * @return
     */
    @ApiOperation("删除规格单位")
    @PostMapping("/delete")
    public CommonResult delete(Integer id) {
        if (sxSpecsUnitService.delete(id) == 1) {
            return CommonResult.success();
        }
        return CommonResult.fail(ResponseCode.DELETE_FALSE);
    }

    /**
     * 根据单位规格id查询单位单位规格
     *
     * @param id
     * @return
     */
    @ApiOperation("根据单位规格id查询单位单位规格")
    @GetMapping("/findById")
    public CommonResult findById(Integer id) {
        return CommonResult.success(sxSpecsUnitService.findById(id));
    }

    /**
     * 批量删除
     */
    @ApiOperation("批量删除")
    @PostMapping("/batchDelete")
    public CommonResult batchDelete(@RequestParam("ids") List<Integer> ids) {
        try {
            sxSpecsUnitService.batchDelete(ids);
            return CommonResult.success();
        } catch (Exception e) {
            e.printStackTrace();
            return CommonResult.fail(ResponseCode.DELETE_FALSE);
        }

    }
}
