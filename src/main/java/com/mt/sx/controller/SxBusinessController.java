package com.mt.sx.controller;

import com.mt.sx.common.base.CommonResult;
import com.mt.sx.common.enums.ResponseCode;
import com.mt.sx.pojo.SxBusiness;
import com.mt.sx.service.SxBusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/business")
public class SxBusinessController {
    @Autowired
    SxBusinessService sxBusinessService;

    /**
     * 查询所有商户
     * @param
     * @return
     */
    @GetMapping("/list")
    public CommonResult list(@RequestParam(value = "page",required = false,defaultValue = "1") Integer page,
                             @RequestParam(value = "pageSize",required = false,defaultValue = "10")Integer pageSize,
                             @RequestParam(value = "name",required = false,defaultValue = "")String name){
       return CommonResult.success( sxBusinessService.list(page,pageSize,name));
    }

    /**
     * 根据id查询商户
     * @param id
     * @return
     */
    @GetMapping("/findById")
    public CommonResult<SxBusiness> findById(@RequestParam("id") Integer id){
        return  CommonResult.success(sxBusinessService.findById(id));
    }

    /**
     * 更新商户
     * @param sxBusiness
     * @return
     */
    @PostMapping("/update")
    public CommonResult update(SxBusiness sxBusiness){
        try {
            sxBusinessService.update(sxBusiness);
            return CommonResult.success();
        } catch (Exception e) {
            e.printStackTrace();
            return CommonResult.fail(ResponseCode.UPDATE_FALSE);
        }
    }

    /**
     * 增加商户
     * @param sxBusiness
     * @return
     */
    @PostMapping("/insert")
    public CommonResult insert(SxBusiness sxBusiness){
        try {
            sxBusinessService.insert(sxBusiness);
            return CommonResult.success();
        } catch (Exception e) {
            e.printStackTrace();
            return CommonResult.fail(ResponseCode.INSERT_FALSE);
        }
    }

    /**
     * 删除
     * @param id
     * @return
     */
    @PostMapping("/delete")
    public CommonResult delete(Integer id){
        try {
            sxBusinessService.delete(id);
            return  CommonResult.success();
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
            sxBusinessService.batchDelete(ids);
            return CommonResult.success();
        } catch (Exception e) {
            e.printStackTrace();
            return CommonResult.fail(ResponseCode.DELETE_FALSE);
        }
    }
}
