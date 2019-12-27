package com.mt.sx.controller;

import com.mt.sx.common.base.CommonResult;
import com.mt.sx.common.enums.ResponseCode;
import com.mt.sx.pojo.SxCategory;
import com.mt.sx.service.SxCategoryService;
<<<<<<< Updated upstream
=======
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
>>>>>>> Stashed changes
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "商品分类接口")
@RestController
@RequestMapping("/category")
public class SxCategoryController {
    @Autowired
    SxCategoryService sxCategoryService;

    /**
     * 查询所有大分类
     *
     * @return
     */
<<<<<<< Updated upstream
=======
    //@RequiresRoles("admin")
    @ApiOperation("查询商品分类接口")
    @RequiresPermissions("product:select")
>>>>>>> Stashed changes
    @GetMapping("/list")
    public CommonResult<List<SxCategory>> list() {
        return CommonResult.success(sxCategoryService.list());
    }

    /**
     * 更新大分类
     *
     * @param sxCategory
     * @return
     */
    @ApiOperation("更新商品分类信息")
    @PostMapping("/update")
    public CommonResult updateCategory(SxCategory sxCategory) {
        try {
            sxCategoryService.updateCategory(sxCategory);
            return CommonResult.success();
        } catch (Exception e) {
            e.printStackTrace();
            return CommonResult.fail(ResponseCode.FAILED);
        }
    }

    /**
     * 插入大分类
     *
     * @param sxCategory
     * @return
     */
    @ApiOperation("插入新的分类信息")
    @PostMapping("/insert")
    public CommonResult insertCategory(SxCategory sxCategory) {
        try {
            sxCategoryService.insertCategory(sxCategory);
           return CommonResult.success();
        } catch (Exception e) {
            e.printStackTrace();
            return CommonResult.fail(ResponseCode.FAILED);
        }
    }

    /**
     * 删除大分类
     *
     * @param id
     * @return
     */
    @ApiOperation("删除分类信息")
    @PostMapping("/delete")
    public CommonResult deleteCategory(@RequestParam("id") Integer id) {
        try {
            sxCategoryService.deleteCategory(id) ;
                return CommonResult.success();


        } catch (Exception e) {
            e.printStackTrace();
            return CommonResult.fail(ResponseCode.FAILED);
        }
    }

    /**
     * 根据id查询大分类
     *
     * @param id
     * @return
     */
    @ApiOperation("根据分类的id查询分类信息")
    @GetMapping("/findById")
    public CommonResult findById(@RequestParam("id") Integer id) {
        return CommonResult.success(sxCategoryService.findById(id));
    }

    /**
     * 批量删除大分类
     */
    @ApiOperation("批量删除分类")
    @PostMapping("/batchDelete")
    public CommonResult batchDelete(@RequestParam("ids") List<Integer> ids) {
        try {
            sxCategoryService.batchDelete(ids);
            return CommonResult.success();
        } catch (Exception e) {
            e.printStackTrace();
            return CommonResult.fail(ResponseCode.DELETE_FALSE);
        }
    }
}
