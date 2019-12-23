package com.mt.sx.controller;

import com.mt.sx.common.base.CommonResult;
import com.mt.sx.common.enums.ResponseCode;
import com.mt.sx.pojo.SxPermission;
import com.mt.sx.service.SxPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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


    /**
     * 查询所有权限
     */
    @GetMapping("/listMenu")
    public CommonResult listMenu(@RequestParam(value = "page",required = false,defaultValue = "1") Integer page,
                                       @RequestParam(value = "pageSize",required = false,defaultValue = "10")Integer pageSize,
                                       @RequestParam(value = "title",required = false,defaultValue = "") String title) {
        try {
            return CommonResult.success(sxPermissionService.listMenu(page, pageSize, title));
        } catch (Exception e) {
            e.printStackTrace();
            return CommonResult.fail(ResponseCode.SELECT_FALSE);
        }
    }


    /**
     * 增加权限
     */
    @PostMapping("/insertMenu")
    public  CommonResult insertMenu(SxPermission sxPermission){
        try {
            sxPermissionService.insertMenu(sxPermission);
            return CommonResult.success();
        } catch (Exception e) {
            e.printStackTrace();
            return CommonResult.fail(ResponseCode.INSERT_FALSE);
        }
    }

    /**
     * 修改权限
     */
    @PostMapping("/updateMenu")
    public CommonResult updateMenu(SxPermission sxPermission){
        try {
            sxPermissionService.updateMenu(sxPermission);
            return CommonResult.success();
        } catch (Exception e) {
            e.printStackTrace();
            return CommonResult.fail(ResponseCode.UPDATE_FALSE);
        }

    }

    /**
     * 删除权限
     */
    @PostMapping("/deleteMenu")
    public CommonResult deleteMenu(Integer id){
        try {
            sxPermissionService.deleteMenu(id);
            return CommonResult.success();
        } catch (Exception e) {
            e.printStackTrace();
            return CommonResult.fail(ResponseCode.DELETE_FALSE);
        }

    }

    /**
     * 批量删除
     */
    @PostMapping("/batchDeleteMenu")
    public CommonResult batchDeleteMenu(List<Integer> ids){
        try {
            sxPermissionService.batchDeleteMenu(ids);
            return CommonResult.success();
        } catch (Exception e) {
            e.printStackTrace();
            return CommonResult.fail(ResponseCode.DELETE_FALSE);
        }
    }
    /**
     * 根据菜单id查询子菜单
     */
    @GetMapping("/findMenuByPid")
    public CommonResult findMenuByPid(@RequestParam("id") Integer id){
        try {
            List<SxPermission> menus=sxPermissionService.findMenuByPid(id);
            return CommonResult.success(menus);
        } catch (Exception e) {
            e.printStackTrace();
            return CommonResult.fail(ResponseCode.SELECT_FALSE);
        }

    }
}
