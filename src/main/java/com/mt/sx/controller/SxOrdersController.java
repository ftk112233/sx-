package com.mt.sx.controller;

import com.mt.sx.common.base.CommonResult;
import com.mt.sx.pojo.SxOrder;
import com.mt.sx.service.SxOrdersService;
import io.lettuce.core.dynamic.annotation.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("order")
public class SxOrdersController {
    @Autowired
    private SxOrdersService sxOrdersService;

    //首先需要回显购物车提交到订单里面的回显数据
    //需要前端解析出提交的所有的商品id，传回一个list,是购物车的listID>
    @PostMapping("findForCart")
    public CommonResult findCart(@RequestParam List list) {
        return CommonResult.success(sxOrdersService.findForCart(list));
    }

    @PostMapping("insertOrder")
    public CommonResult insertOrder(@RequestParam("list") List<Integer> list, @RequestParam("addressId")Integer addressId, @RequestParam("message") String message, @RequestParam("hopeTime") Date hopeTime) {
        return CommonResult.success(sxOrdersService.insertOrder(list, addressId, message, hopeTime));
    }


    @GetMapping("findSubOrders")//查看子订单，当传入类型时按类型查询。未传入类型时默认查询所有的数据
    public CommonResult findSubOrders(Integer type) {
        return CommonResult.success(sxOrdersService.findSubOrders(type));
    }

    @GetMapping("findOrdersInfo")//查看订单详情，当传入类型时按类型查询。未传入类型时默认查询所有的数据
    public CommonResult findOrdersInfo(@RequestParam("id") Integer id) {
        return CommonResult.success(sxOrdersService.findOrdersInfo(id));
    }

    @GetMapping("adminFindSubOrder")
    public CommonResult adminFindSubOrder(String suborderId){
        return CommonResult.success(sxOrdersService.adminFindSubOrder(suborderId));
    }

    @PostMapping("addPassBy")
    public CommonResult adminFindSubOrder(String suborderId,Integer passById){
        return CommonResult.success(sxOrdersService.addPassBy(suborderId,passById));
    }


}
