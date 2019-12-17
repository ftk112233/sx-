package com.mt.sx.pojo;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Table(name = "sx_cart")
public class SxCart  implements Serializable {
    /**
     * 自增id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 数量
     */
    private Integer number;

    /**
     * n个商品总价格
     */
    private BigDecimal prices;

    /**
     * 排序
     */
    private Integer sort;

    /**
     * 商品id
     */
    @Column(name = "product_id")
    private Integer productId;

    /**
     * 买家id
     */
    @Column(name = "shop_id")
    private Integer shopId;

    /**
     * 创建者
     */
    @Column(name = "create_by")
    private String createBy;

    /**
     * 更新者
     */
    @Column(name = "update_by")
    private String updateBy;

    /**
     * 创建时间
     */
    @Column(name = "update_time")
    private Date updateTime;

    /**
     * 更新时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 商家id
     */
    @Column(name = "business_id")
    private Integer businessId;

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
     * 获取n个商品总价格
     *
     * @return prices - n个商品总价格
     */
    public BigDecimal getPrices() {
        return prices;
    }

    /**
     * 设置n个商品总价格
     *
     * @param prices n个商品总价格
     */
    public void setPrices(BigDecimal prices) {
        this.prices = prices;
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
     * 获取商品id
     *
     * @return product_id - 商品id
     */
    public Integer getProductId() {
        return productId;
    }

    /**
     * 设置商品id
     *
     * @param productId 商品id
     */
    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    /**
     * 获取买家id
     *
     * @return shop_id - 买家id
     */
    public Integer getShopId() {
        return shopId;
    }

    /**
     * 设置买家id
     *
     * @param shopId 买家id
     */
    public void setShopId(Integer shopId) {
        this.shopId = shopId;
    }

    /**
     * 获取创建者
     *
     * @return create_by - 创建者
     */
    public String getCreateBy() {
        return createBy;
    }

    /**
     * 设置创建者
     *
     * @param createBy 创建者
     */
    public void setCreateBy(String createBy) {
        this.createBy = createBy == null ? null : createBy.trim();
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
     * 获取创建时间
     *
     * @return update_time - 创建时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置创建时间
     *
     * @param updateTime 创建时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 获取更新时间
     *
     * @return create_time - 更新时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置更新时间
     *
     * @param createTime 更新时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getBusinessId() {
        return businessId;
    }

    public void setBusinessId(Integer businessId) {
        this.businessId = businessId;
    }
}