package com.mt.sx.common.util;

import com.mt.sx.pojo.SxBusiness;

public class BusinessUtils {
    public static SxBusiness getBusiness(){
        SxBusiness business = (SxBusiness)WebUtils.getSession().getAttribute("user");
        return business;
    }
}
