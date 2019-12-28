package com.mt.sx.pojo;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Table(name = "sx_product")
public class SxProduct  implements Serializable {
    /**
     * 自增id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
     * 现价
     */
    private BigDecimal price;

    /**
     * 原价
     */
    @Column(name = "pre_price")
    private BigDecimal prePrice;

    /**
     * 库存数量
     */
    private Integer number;

    /**
     * 单位
     */
    private String unit;

    /**
     * 按什么方式卖
     */
    private String speway;

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
     * 已售数量
     */
    private Integer count;

    /**
     * 添加时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 添加者
     */
    @Column(name = "create_by")
    private String createBy;

    /**
     * 更新时间
     */
    @Column(name = "update_time")
    private Date updateTime;

    /**
     * 更新者
     */
    @Column(name = "update_by")
    private String updateBy;

    /**
     * 卖家店铺id
     */
    @Column(name = "business_id")
    private Integer businessId;

    @Transient
    private SxComment sxComment;

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
     * 获取现价
     *
     * @return price - 现价
     */
    public BigDecimal getPrice() {
        return price;
    }

    /**
     * 设置现价
     *
     * @param price 现价
     */
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    /**
     * 获取原价
     *
     * @return pre_price - 原价
     */
    public BigDecimal getPrePrice() {
        return prePrice;
    }

    /**
     * 设置原价
     *
     * @param prePrice 原价
     */
    public void setPrePrice(BigDecimal prePrice) {
        this.prePrice = prePrice;
    }

    /**
     * 获取库存数量
     *
     * @return number - 库存数量
     */
    public Integer getNumber() {
        return number;
    }

    /**
     * 设置库存数量
     *
     * @param number 库存数量
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
     * 获取按什么方式卖
     *
     * @return speway - 按什么方式卖
     */
    public String getSpeway() {
        return speway;
    }

    /**
     * 设置按什么方式卖
     *
     * @param speway 按什么方式卖
     */
    public void setSpeway(String speway) {
        this.speway = speway == null ? null : speway.trim();
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

    /**
     * 获取已售数量
     *
     * @return count - 已售数量
     */
    public Integer getCount() {
        return count;
    }

    /**
     * 设置已售数量
     *
     * @param count 已售数量
     */
    public void setCount(Integer count) {
        this.count = count;
    }

    /**
     * 获取添加时间
     *
     * @return create_time - 添加时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置添加时间
     *
     * @param createTime 添加时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取添加者
     *
     * @return create_by - 添加者
     */
    public String getCreateBy() {
        return createBy;
    }

    /**
     * 设置添加者
     *
     * @param createBy 添加者
     */
    public void setCreateBy(String createBy) {
        this.createBy = createBy == null ? null : createBy.trim();
    }

    /**
     * 获取更新时间
     *
     * @return update_time - 更新时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置更新时间
     *
     * @param updateTime 更新时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 获取更新者
     *
     * @return update_by - 更新者
     */
    public String getUpdateBy() {
        return updateBy;
    }

    /**
     * 设置更新者
     *
     * @param updateBy 更新者
     */
    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy == null ? null : updateBy.trim();
    }

    /**
     * 获取卖家店铺id
     *
     * @return business_id - 卖家店铺id
     */
    public Integer getBusinessId() {
        return businessId;
    }

    /**
     * 设置卖家店铺id
     *
     * @param businessId 卖家店铺id
     */
    public void setBusinessId(Integer businessId) {
        this.businessId = businessId;
    }

    public SxComment getSxComment() {
        return sxComment;
    }

    public void setSxComment(SxComment sxComment) {
        this.sxComment = sxComment;
    }
}