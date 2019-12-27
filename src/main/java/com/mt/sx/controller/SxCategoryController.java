package com.mt.sx.controller;

import com.mt.sx.common.base.CommonResult;
import com.mt.sx.common.enums.ResponseCode;
import com.mt.sx.pojo.SxCategory;
import com.mt.sx.service.SxCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
     * @param id
     * @return
     */
    @GetMapping("/findById")
    public CommonResult findById(@RequestParam("id") Integer id) {
        return CommonResult.success(sxCategoryService.findById(id));
    }

    /**
     * 批量删除大分类
     */
    @PostMapping("/batchDelete")
    public CommonResult batchDelete(@RequestParam("ids") List<Integer> ids){
        try {
            sxCategoryService.batchDelete(ids);
            return CommonResult.success();
        } catch (Exception e) {
            e.printStackTrace();
            return CommonResult.fail(ResponseCode.DELETE_FALSE);
        }
    }
}
