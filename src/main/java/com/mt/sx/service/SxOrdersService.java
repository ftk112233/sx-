package com.mt.sx.service;


import com.mt.sx.common.base.CommonResult;
import com.mt.sx.pojo.SxOrderInfo;
import com.mt.sx.pojo.vo.SxSubOrderVo;

import java.util.Date;
import java.util.List;

public interface SxOrdersService {




    List findForCart(List<Integer> list) ;

    CommonResult insertOrder(List<Integer> list, Integer addressId, String message, Date hopeTime);

    List<SxSubOrderVo> findSubOrders(Integer type);

    SxOrderInfo findOrdersInfo(Integer id);
}
