package com.mt.sx.controller;

import com.mt.sx.common.base.CommonResult;
import com.mt.sx.common.enums.ResponseCode;
import com.mt.sx.pojo.SxComment;
import com.mt.sx.service.SxCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comment")
public class SxCommentController {
    @Autowired
    SxCommentService sxCommentService;

    /**
     * 分页查询所有评论
     * @param page
     * @param pageSize
     * @return
     */
    @GetMapping("/list")
    public CommonResult list(Integer page, Integer pageSize){
       return CommonResult.success( sxCommentService.list(page,pageSize));
    }

    /**
     * 添加一条评论
     * @param sxComment
     * @return
     */
    @PostMapping("/insert")
    public CommonResult insert(SxComment sxComment){
        try {
            sxCommentService.insert(sxComment) ;
            return CommonResult.success();
        } catch (Exception e) {
            e.printStackTrace();
            return CommonResult.fail(ResponseCode.INSERT_FALSE);
        }


    }

    /**
     * 删除一条评论
     * @param sxComment
     * @return
     */
    @PostMapping("/delete")
    public CommonResult delete(SxComment sxComment){
        try {
            sxCommentService.insert(sxComment);
            return CommonResult.success();
        } catch (Exception e) {
            e.printStackTrace();
            return CommonResult.fail(ResponseCode.DELETE_FALSE);
        }


    }

    @GetMapping("/findByProductId")
    public CommonResult<List<SxComment>> findByProductId(@RequestParam("productId") Integer productId){
        return CommonResult.success(sxCommentService.findByProductId(productId));
    }

    /**
     * 批量删除
     */
    @PostMapping("/batchDelete")
    public CommonResult batchDelete(@RequestParam("ids") List<Integer> ids){
        try {
            sxCommentService.batchDelete(ids);
            return CommonResult.success();
        } catch (Exception e) {
            e.printStackTrace();
            return CommonResult.fail(ResponseCode.DELETE_FALSE);
        }

    }
}
