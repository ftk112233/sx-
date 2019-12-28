package com.mt.sx.controller;

import com.mt.sx.common.base.CommonResult;
import com.mt.sx.common.enums.ResponseCode;
import com.mt.sx.pojo.SxPermission;
import com.mt.sx.service.SxPermissionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@Api(tags = "权限管理接口")
@RestController
@RequestMapping("/permission")
public class SxPermissionController {
    @Autowired
    SxPermissionService sxPermissionService;

    /**
     * 查询所有权限
     */
    @ApiOperation("查询所有权限")
    @GetMapping("/listPermission")
    public CommonResult listPermission(@RequestParam(value = "page",required = false,defaultValue = "1") Integer page,
                                                           @RequestParam(value = "pageSize",required = false,defaultValue = "10")Integer pageSize,
                                                           @RequestParam(value = "percode",required = false,defaultValue = "") String percode) {
        try {
           return CommonResult.success(sxPermissionService.listPermission(page, pageSize, percode));
        } catch (Exception e) {
            e.printStackTrace();
            return CommonResult.fail(ResponseCode.SELECT_FALSE);
        }
    }


    /**
     * 增加权限
     */
    @ApiOperation("增加权限")
    @PostMapping("/insertPermission")
    public  CommonResult insertPermission(SxPermission sxPermission){
        try {
            sxPermissionService.insertPermission(sxPermission);
            return CommonResult.success();
        } catch (Exception e) {
            e.printStackTrace();
            return CommonResult.fail(ResponseCode.INSERT_FALSE);
        }
    }

    /**
     * 修改权限
     */
    @ApiOperation("修改权限")
    @PostMapping("/updatePermission")
    public CommonResult updatePermission(SxPermission sxPermission){
        try {
            sxPermissionService.updatePermission(sxPermission);
            return CommonResult.success();
        } catch (Exception e) {
            e.printStackTrace();
            return CommonResult.fail(ResponseCode.UPDATE_FALSE);
        }

    }

    /**
     * 删除权限
     */
    @ApiOperation("删除权限")
    @PostMapping("/deletePermission")
    public CommonResult deletePermission(@RequestParam("id") Integer id){
        try {
            sxPermissionService.deletePermission(id);
            return CommonResult.success();
        } catch (Exception e) {
            e.printStackTrace();
            return CommonResult.fail(ResponseCode.DELETE_FALSE);
        }

    }

    /**
     * 批量删除
     */
    @ApiOperation("批量删除")
    @PostMapping("/batchDeletePermission")
    public CommonResult batchDeletePermission(@RequestParam("ids") List<Integer> ids){
        try {
            sxPermissionService.batchDeletePermisson(ids);
            return CommonResult.success();
        } catch (Exception e) {
            e.printStackTrace();
            return CommonResult.fail(ResponseCode.DELETE_FALSE);
        }
    }

    /**
     * 根据父菜单id查询子权限
     */
    @ApiOperation("根据父菜单id查询子权限")
    @GetMapping("/findPermissionByPid")
    public CommonResult findPermissionByPid(Integer id){
        try {
            List<SxPermission> permissions=sxPermissionService.findPermissionByPid(id);
            return CommonResult.success(permissions);
        } catch (Exception e) {
            e.printStackTrace();
            return CommonResult.fail(ResponseCode.SELECT_FALSE);
        }
    }
}
