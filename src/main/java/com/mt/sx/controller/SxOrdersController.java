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
    @PostMapping("findForCart")//提交订单时购物车的回显
    public CommonResult findCart(@RequestParam List list) {
        return CommonResult.success(sxOrdersService.findForCart(list));
    }

    @PostMapping("insertOrder")//生成订单
    public CommonResult insertOrder(@RequestParam("list") List<Integer> list, @RequestParam("addressId") Integer addressId, @RequestParam("message") String message, @RequestParam("hopeTime") Date hopeTime) {
        return CommonResult.success(sxOrdersService.insertOrder(list, addressId, message, hopeTime));
    }//生成完订单后需要调用删除购物车列表的方法，清除掉相应的购物车数据，方法在SxCartController中


    @GetMapping("findSubOrdersForUser")//查看子订单，当传入类型时按类型查询。未传入类型时默认查询所有的数据
    public CommonResult findSubOrders(Integer type) {
        return CommonResult.success(sxOrdersService.findSubOrders(type));
    }

    @GetMapping("findOrdersInfo")//查看订单详情，当传入类型时按类型查询。未传入类型时默认查询所有的数据
    public CommonResult findOrdersInfo(@RequestParam("id") Integer id) {
        return CommonResult.success(sxOrdersService.findOrdersInfo(id));
    }

//    @GetMapping("adminFindSubOrder")//管理员根据单号查询订单
//    public CommonResult adminFindSubOrder(String suborderId) {
//        return CommonResult.success(sxOrdersService.adminFindSubOrder(suborderId));
//    }

    @PostMapping("addPassBy")//商家添加配送员发货
    public CommonResult adminFindSubOrder(String suborderId, Integer passById) {
        return CommonResult.success(sxOrdersService.addPassBy(suborderId, passById));
    }

    @PostMapping("cancelOrder")//卖家取消订单，在付款之前
    public CommonResult cancelOrder(String suborderId) {
        return CommonResult.success(sxOrdersService.cancelOrder(suborderId));
    }

    @PostMapping("cancelOrderForTable")//商家取消订单，只能在发货前取消，钱需要商家自行处理退回
    public CommonResult cancelOrderForTable(String suborderId) {
        return CommonResult.success(sxOrdersService.cancelOrderForTable(suborderId));
    }

    @GetMapping("findSubOrdersForTable")//查看子订单，当传入类型时按类型查询。未传入类型时默认查询所有的数据
    public CommonResult findSubOrdersForTable(Integer type) {
        return CommonResult.success(sxOrdersService.findSubOrdersForTable(type));
    }

    @GetMapping("totalConsume")
    public CommonResult totalConsume() {
        return CommonResult.success(sxOrdersService.totalConsume());
    }

}
