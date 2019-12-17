package com.mt.sx.controller;

import com.mt.sx.common.base.CommonResult;
import com.mt.sx.common.enums.ResponseCode;
import com.mt.sx.mapper.SxRoleMapper;
import com.mt.sx.pojo.SxRole;
import com.mt.sx.pojo.vo.SxRoleVo;
import com.mt.sx.service.SxRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/role")
public class SxRoleController {
    @Autowired
    SxRoleService sxRoleService;

    /**
     * 角色查询
     * @return
     */
    @GetMapping("/list")
    public CommonResult<List<SxRole>> list(SxRoleVo sxRoleVo){
        return CommonResult.success(sxRoleService.list(sxRoleVo));
    }

    /**
     * 根据角色id查询角色
     * @param id
     * @return
     */
    @GetMapping("/findById")
    public CommonResult<SxRole> findById(@RequestParam("id") Integer id){
        return CommonResult.success(sxRoleService.findById(id));
    }

    /**
     * 添加角色
     * @param sxRole
     * @return
     */
    @PostMapping("/insert")
    public CommonResult insert(SxRole sxRole){
        try {
            sxRoleService.insert(sxRole);
            return CommonResult.success();
        } catch (Exception e) {
            e.printStackTrace();
            return CommonResult.fail(ResponseCode.INSERT_FALSE);
        }
    }

    /**
     * 更新角色
     * @param sxRole
     * @return
     */
    @PostMapping("/update")
    public CommonResult update(SxRole sxRole){
        try {
            sxRoleService.update(sxRole);
            return CommonResult.success();
        } catch (Exception e) {
            e.printStackTrace();
            return CommonResult.fail(ResponseCode.UPDATE_FALSE);
        }
    }

    /**
     * 删除角色
     * @param id
     * @return
     */
    @PostMapping("/delete")
    public CommonResult delete(@RequestParam("id") Integer id){
        try {
            sxRoleService.delete(id);
            return CommonResult.success();
        } catch (Exception e) {
            e.printStackTrace();
            return CommonResult.fail(ResponseCode.DELETE_FALSE);
        }
    }

    /**
     * 批量删除
     * @param ids
     * @return
     */
    @PostMapping("/batchDelete")
    public CommonResult batchDelete(@RequestParam("ids") List<Integer> ids){
        try {
            sxRoleService.batchDelete(ids);
            return CommonResult.success();
        } catch (Exception e) {
            e.printStackTrace();
            return CommonResult.fail(ResponseCode.DELETE_FALSE);
        }

    }

    /**
     * 给角色添加权限
     * @param id
     * @param ids
     * @return
     */
    @PostMapping("/saveRolePermission")
    public CommonResult saveRolePermission(@RequestParam("id") Integer id,@RequestParam("ids") List<Integer> ids){
        try {
            sxRoleService.saveRolePermission(id,ids);
            return CommonResult.success();
        } catch (Exception e) {
            e.printStackTrace();
            return CommonResult.fail(ResponseCode.INSERT_FALSE);
        }

    }


}
