package com.mt.sx.service;


import com.mt.sx.common.base.CommonResult;
import com.mt.sx.pojo.SxOrder;
import com.mt.sx.pojo.SxOrderInfo;
import com.mt.sx.pojo.SxSubOrder;
import com.mt.sx.pojo.vo.SxSubOrderVo;

import java.util.Date;
import java.util.List;

public interface SxOrdersService {

    List findForCart(List<Integer> list) ;

    CommonResult insertOrder(List<Integer> list, Integer addressId, String message, Date hopeTime);

    List<SxSubOrderVo> findSubOrders(Integer type);

    SxOrderInfo findOrdersInfo(Integer id);

    List<List<SxSubOrderVo>> findSubOrderByList(List<String> subIdList);

    CommonResult addPassBy(String suborderId, Integer passById);

    CommonResult cancelOrder(String suborderId);

    CommonResult cancelOrderForTable(String suborderId);

    List<SxSubOrderVo> findSubOrdersForTable(Integer type);

    CommonResult totalConsume();

    CommonResult findSubOrderByName(String name, String subOrderId);

}
