package com.mt.sx.controller;

import com.mt.sx.common.base.CommonResult;
import com.mt.sx.pojo.SxOrder;
import com.mt.sx.service.SxOrdersService;
import io.lettuce.core.dynamic.annotation.Param;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Api(tags = "用户订单接口")
@RestController
@RequestMapping("order")
public class SxOrdersController {
    @Autowired
    private SxOrdersService sxOrdersService;


    /**
     * 提交订单时购物车的回显
     *
     * @param list
     * @return
     */
    //首先需要回显购物车提交到订单里面的回显数据
    //需要前端解析出提交的所有的商品id，传回一个list,是购物车的商品listId>
    @ApiOperation("提交订单时购物车数据的回显")
    @PostMapping("findForCart")//提交订单时购物车的回显
    public CommonResult findCart(@RequestParam List list) {
        return CommonResult.success(sxOrdersService.findForCart(list));
    }

    /**
     * 提交购物车后的提交订单（生成订单功能）
     *
     * @param list
     * @param addressId
     * @param message
     * @param hopeTime
     * @return
     */
    @ApiOperation("生成订单")
    @PostMapping("insertOrder")//生成订单
    public CommonResult insertOrder(@RequestParam("list") List<Integer> list, @RequestParam("addressId") Integer addressId, @RequestParam("message") String message, @RequestParam("hopeTime") Date hopeTime) {
        return CommonResult.success(sxOrdersService.insertOrder(list, addressId, message, hopeTime));
    }//生成完订单后需要调用删除购物车列表的方法，清除掉相应的购物车数据，方法在SxCartController中

    /**
     * 用户查询属于自己的订单（可以查询已发货，未发货等等信息）
     *
     * @param type
     * @return
     */
    @ApiOperation(value = "查看子订单", notes = "可以传入需要的类型参数，如发货的状态代码，不传递则查看所有")
    @GetMapping("findSubOrdersForUser")//查看子订单，当传入类型时按类型查询。未传入类型时默认查询所有的数据
    public CommonResult findSubOrders(Integer type) {
        return CommonResult.success(sxOrdersService.findSubOrders(type));
    }

    @ApiOperation(value = "查看订单的详情", notes = "传入的是订单的详情id")
    @GetMapping("findOrdersInfo")//查看订单详情
    public CommonResult findOrdersInfo(@RequestParam("id") Integer id) {
        return CommonResult.success(sxOrdersService.findOrdersInfo(id));
    }

    @ApiOperation(value = "根据单号查询订单", notes = "可以传单个的订单号也可以传递订单号的集合")
    @GetMapping("findSubOrderByList")//管理员根据单号查询订单
    public CommonResult findSubOrderByList(@RequestParam("subIdList") List<String> subIdList) {
        return CommonResult.success(sxOrdersService.findSubOrderByList(subIdList));
    }

    @ApiOperation(value = "为订单添加派送员", notes = "只有商家才能操作此接口，会自动的获取redis中店家的id")
    @PostMapping("addPassBy")//商家添加配送员发货
    public CommonResult adminFindSubOrder(String suborderId, Integer passById) {
        return CommonResult.success(sxOrdersService.addPassBy(suborderId, passById));
    }

    @ApiOperation("买家取消未支付的订单")
    @PostMapping("cancelOrder")//买家取消订单，在付款之前
    public CommonResult cancelOrder(String suborderId) {
        return CommonResult.success(sxOrdersService.cancelOrder(suborderId));
    }

    @ApiOperation(value = "卖家取消已支付的订单", notes = "已发货的订单无法取消")
    @PostMapping("cancelOrderForTable")//商家取消订单，只能在发货前取消，钱需要商家自行处理退回
    public CommonResult cancelOrderForTable(String suborderId) {
        return CommonResult.success(sxOrdersService.cancelOrderForTable(suborderId));
    }

    @ApiOperation(value = "查看当前用户的子订单的列表", notes = "可以不传递类型参数进来，默认为查询所有的订单列表")
    @GetMapping("findSubOrdersForTable")//查看子订单，当传入类型时按类型查询。未传入类型时默认查询所有的数据
    public CommonResult findSubOrdersForTable(Integer type) {
        return CommonResult.success(sxOrdersService.findSubOrdersForTable(type));
    }

    @ApiOperation(value = "查看总消费额", notes = "普通用户查看自己的总消费额，商家查看的是总收益，平台查看的是所有的的交易额")
    @GetMapping("totalConsume")
    public CommonResult totalConsume() {
        return CommonResult.success(sxOrdersService.totalConsume());
    }

    @ApiOperation(value = "模糊查询订单中含有的商品名称", notes = "返回的是一个suborder的list集合，后续需要调用查询订单集合的方法")
    @GetMapping("findSubOrderByNameOrId")
    public CommonResult findSubOrderByName(String name, String subOrderId) {
        return CommonResult.success(sxOrdersService.findSubOrderByName(name, subOrderId));
    }

}
