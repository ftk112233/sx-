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
     * 查询所有分类
     *
     * @return
     */
    @GetMapping("/list")
    public CommonResult<List<SxCategory>> list() {
        return CommonResult.success(sxCategoryService.list());
    }

    /**
     * 更新分类
     *
     * @param sxCategory
     * @return
     */
    @PostMapping("/update")
    public CommonResult updateCategory(SxCategory sxCategory) {
        try {
            if (sxCategoryService.updateCategory(sxCategory) == 1) {
                return CommonResult.success();
            }

        } catch (Exception e) {
            e.printStackTrace();
            return CommonResult.fail(ResponseCode.FAILED);
        }
        return CommonResult.fail(-1, "更新失败！");
    }

    /**
     * 插入分类
     *
     * @param sxCategory
     * @return
     */

    @PostMapping("/insert")
    public CommonResult insertCategory(SxCategory sxCategory) {
        try {
            if (sxCategoryService.insertCategory(sxCategory) == 1) {
                return CommonResult.success();
            }

        } catch (Exception e) {
            e.printStackTrace();
            return CommonResult.fail(ResponseCode.FAILED);
        }
        return CommonResult.fail(-1, "添加失败！");
    }

    /**
     * 删除分类
     *
     * @param id
     * @return
     */
    @PostMapping("/delete")
    public CommonResult deleteCategory(@RequestParam("id") Integer id) {
        try {
            if (sxCategoryService.deleteCategory(id) == 1) {
                return CommonResult.success();
            }

        } catch (Exception e) {
            e.printStackTrace();
            return CommonResult.fail(ResponseCode.FAILED);
        }
        return CommonResult.fail(-1, "删除失败！");

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


}
