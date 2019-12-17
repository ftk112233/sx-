package com.mt.sx.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

@Table(name = "sx_sku")
public class SxSku  implements Serializable {
    /**
     * 自增id
     */
    @Id
    private Integer id;

    /**
     * 商品名称
     */
    private String name;

    /**
     * 商品描述
     */
    private String description;

    /**
     * 单价
     */
    private BigDecimal price;

    /**
     * 折扣
     */
    private BigDecimal discount;

    /**
     * 数量
     */
    private Integer number;

    /**
     * 单位
     */
    private String unit;

    /**
     * 添加时间
     */
    @Column(name = "add_time")
    private Date addTime;

    /**
     * 0:上架 1:下架
     */
    private Integer status;

    /**
     * 图片地址
     */
    private String pic;

    /**
     * 排序
     */
    private Integer sort;

    /**
     * 商品集合id
     */
    @Column(name = "spu_id")
    private Integer spuId;

    /**
     * 获取自增id
     *
     * @return id - 自增id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置自增id
     *
     * @param id 自增id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取商品名称
     *
     * @return name - 商品名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置商品名称
     *
     * @param name 商品名称
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 获取商品描述
     *
     * @return description - 商品描述
     */
    public String getDescription() {
        return description;
    }

    /**
     * 设置商品描述
     *
     * @param description 商品描述
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    /**
     * 获取单价
     *
     * @return price - 单价
     */
    public BigDecimal getPrice() {
        return price;
    }

    /**
     * 设置单价
     *
     * @param price 单价
     */
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    /**
     * 获取折扣
     *
     * @return discount - 折扣
     */
    public BigDecimal getDiscount() {
        return discount;
    }

    /**
     * 设置折扣
     *
     * @param discount 折扣
     */
    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    /**
     * 获取数量
     *
     * @return number - 数量
     */
    public Integer getNumber() {
        return number;
    }

    /**
     * 设置数量
     *
     * @param number 数量
     */
    public void setNumber(Integer number) {
        this.number = number;
    }

    /**
     * 获取单位
     *
     * @return unit - 单位
     */
    public String getUnit() {
        return unit;
    }

    /**
     * 设置单位
     *
     * @param unit 单位
     */
    public void setUnit(String unit) {
        this.unit = unit == null ? null : unit.trim();
    }

    /**
     * 获取添加时间
     *
     * @return add_time - 添加时间
     */
    public Date getAddTime() {
        return addTime;
    }

    /**
     * 设置添加时间
     *
     * @param addTime 添加时间
     */
    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    /**
     * 获取0:上架 1:下架
     *
     * @return status - 0:上架 1:下架
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置0:上架 1:下架
     *
     * @param status 0:上架 1:下架
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 获取图片地址
     *
     * @return pic - 图片地址
     */
    public String getPic() {
        return pic;
    }

    /**
     * 设置图片地址
     *
     * @param pic 图片地址
     */
    public void setPic(String pic) {
        this.pic = pic == null ? null : pic.trim();
    }

    /**
     * 获取排序
     *
     * @return sort - 排序
     */
    public Integer getSort() {
        return sort;
    }

    /**
     * 设置排序
     *
     * @param sort 排序
     */
    public void setSort(Integer sort) {
        this.sort = sort;
    }

    /**
     * 获取商品集合id
     *
     * @return spu_id - 商品集合id
     */
    public Integer getSpuId() {
        return spuId;
    }

    /**
     * 设置商品集合id
     *
     * @param spuId 商品集合id
     */
    public void setSpuId(Integer spuId) {
        this.spuId = spuId;
    }
}