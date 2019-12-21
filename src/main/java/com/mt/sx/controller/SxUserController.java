package com.mt.sx.controller;

import com.github.pagehelper.PageInfo;
import com.mt.sx.common.base.CommonResult;
import com.mt.sx.common.enums.ResponseCode;
import com.mt.sx.pojo.SxUser;
import com.mt.sx.pojo.vo.SxUserVo;
import com.mt.sx.service.SxUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class SxUserController {
    @Autowired
    SxUserService sxUserService;

    @GetMapping("/list")
    public CommonResult list(@RequestParam(value = "page",required = false,defaultValue = "1") Integer page,
                             @RequestParam(value = "pageSize",required = false,defaultValue = "10") Integer pageSize,
                             @RequestParam(value = "username",required = false,defaultValue = "") String username){
        try {
            PageInfo<SxUser> pageInfo=sxUserService.list(page,pageSize,username);
            return CommonResult.success(pageInfo);
        } catch (Exception e) {
            e.printStackTrace();
            return CommonResult.fail(ResponseCode.SELECT_FALSE);
        }


    }

    @PostMapping("/insert")
    public CommonResult insertUser(SxUser sxUser){
        try {
            sxUserService.insert(sxUser);
            return CommonResult.success();
        } catch (Exception e) {
            e.printStackTrace();
            return CommonResult.fail(ResponseCode.INSERT_FALSE);
        }

    }

    @PostMapping("/update")
    public CommonResult updateUser(SxUser sxUser){
        try {
            sxUserService.updateUser(sxUser);
            return CommonResult.success();
        } catch (Exception e) {
            e.printStackTrace();
            return CommonResult.fail(ResponseCode.UPDATE_FALSE);
        }
    }

    @PostMapping("/delete")
    public CommonResult delete(@RequestParam("id") Integer id){
        try {
            sxUserService.delete(id);
            return CommonResult.success();
        } catch (Exception e) {
            e.printStackTrace();
            return CommonResult.fail(ResponseCode.DELETE_FALSE);
        }
    }

    @PostMapping("/batchDelete")
    public CommonResult delete(@RequestParam("ids")List<Integer> ids){
        try {
            sxUserService.batchDelete(ids);
            return CommonResult.success();
        } catch (Exception e) {
            e.printStackTrace();
            return CommonResult.fail(ResponseCode.DELETE_FALSE);
        }
    }

    @PostMapping("/updatePwd")
    public CommonResult updatePwd(@RequestParam("id") Integer id,@RequestParam("password") String password){
        try {
            sxUserService.updatePwd(id,password);
            return CommonResult.success();
        } catch (Exception e) {
            e.printStackTrace();
            return CommonResult.fail(ResponseCode.UPDATE_FALSE);
        }
    }
}
