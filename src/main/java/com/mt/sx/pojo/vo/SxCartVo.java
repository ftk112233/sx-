package com.mt.sx.pojo.vo;

import com.mt.sx.pojo.SxCart;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
public class SxCartVo extends SxCart{

    private Integer productId;

    /**
     * 商品名称
     */
    private String productName;

    /**
     * 商品描述
     */
    private String productDescription;

    /**
     * 现价
     */
    private BigDecimal productPrice;
    /**
     * 原价
     */
    private BigDecimal productPrePrice;

    /**
     * 库存数量
     */
    private Integer productNumber;

    /**
     * 单位
     */
    private String unit;

    /**
     * 按什么方式卖
     */
    private String speway;


    /**
     * 图片地址
     */
    private String pic;

    private String businessShopName;//店铺名称






}
