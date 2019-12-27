package com.mt.sx.controller;

import com.mt.sx.common.base.CommonResult;
import com.mt.sx.common.enums.ResponseCode;
import com.mt.sx.pojo.SxComment;
import com.mt.sx.service.SxCommentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "商品评价接口")
@RestController
@RequestMapping("/comment")
public class SxCommentController {
    @Autowired
    SxCommentService sxCommentService;

    /**
     * 分页查询所有评论
     *
     * @param page
     * @param pageSize
     * @return
     */
    @ApiOperation("查看店铺所有的评价信息")
    @GetMapping("/list")
    public CommonResult list(Integer page, Integer pageSize) {
        return CommonResult.success(sxCommentService.list(page, pageSize));
    }

    /**
     * 添加一条评论
     *
     * @param sxComment
     * @return
     */
    @ApiOperation("插入心的评价信息")
    @PostMapping("/insert")
<<<<<<< Updated upstream
    public CommonResult insert(SxComment sxComment){
        try {
            sxCommentService.insert(sxComment) ;
=======
    public CommonResult insert(SxComment sxComment) {
        if (sxCommentService.insert(sxComment) == 1) {
>>>>>>> Stashed changes
            return CommonResult.success();
        } catch (Exception e) {
            e.printStackTrace();
            return CommonResult.fail(ResponseCode.INSERT_FALSE);
        }


    }

    /**
     * 删除一条评论
     *
     * @param sxComment
     * @return
     */
    @ApiOperation("删除评价")
    @PostMapping("/delete")
<<<<<<< Updated upstream
    public CommonResult delete(SxComment sxComment){
        try {
            sxCommentService.insert(sxComment);
            return CommonResult.success();
        } catch (Exception e) {
            e.printStackTrace();
            return CommonResult.fail(ResponseCode.DELETE_FALSE);
=======
    public CommonResult delete(SxComment sxComment) {
        if (sxCommentService.insert(sxComment) == 1) {
            return CommonResult.success();
>>>>>>> Stashed changes
        }


    }

    @ApiOperation("根据商品的id查询该商品的所有评价")
    @GetMapping("/findByProductId")
    public CommonResult<List<SxComment>> findByProductId(@RequestParam("productId") Integer productId) {
        return CommonResult.success(sxCommentService.findByProductId(productId));
    }

    /**
     * 批量删除
     */
    @ApiOperation("批量删除评价信息")
    @PostMapping("/batchDelete")
    public CommonResult batchDelete(@RequestParam("ids") List<Integer> ids) {
        try {
            sxCommentService.batchDelete(ids);
            return CommonResult.success();
        } catch (Exception e) {
            e.printStackTrace();
            return CommonResult.fail(ResponseCode.DELETE_FALSE);
        }

    }
}
