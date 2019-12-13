package com.mt.sx.pojo;

import javax.persistence.Column;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;

@Table(name = "sx_sub_order")
public class SxSubOrder {
    /**
     * 子订单id
     */
    @Column(name = "suborder_id")
    private String suborderId;

    /**
     * 父订单id
     */
    @Column(name = "order_id")
    private String orderId;

    /**
     * 商铺id
     */
    @Column(name = "business_id")
    private Integer businessId;

    /**
     * 子订单总价格
     */
    private BigDecimal prices;

    /**
     * 创建者
     */
    @Column(name = "create_by")
    private String createBy;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

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
    @Column(name = "shop_id")
    private Integer shopId;

    public void setShopId(Integer shopId) {
        this.shopId = shopId;
    }

    /**
     * 获取子订单id
     *
     * @return suborder_id - 子订单id
     */
    public String getSuborderId() {
        return suborderId;
    }

    /**
     * 设置子订单id
     *
     * @param suborderId 子订单id
     */
    public void setSuborderId(String suborderId) {
        this.suborderId = suborderId == null ? null : suborderId.trim();
    }

    /**
     * 获取父订单id
     *
     * @return order_id - 父订单id
     */
    public String getOrderId() {
        return orderId;
    }

    /**
     * 设置父订单id
     *
     * @param orderId 父订单id
     */
    public void setOrderId(String orderId) {
        this.orderId = orderId == null ? null : orderId.trim();
    }

    /**
     * 获取商铺id
     *
     * @return business_id - 商铺id
     */
    public Integer getBusinessId() {
        return businessId;
    }

    /**
     * 设置商铺id
     *
     * @param businessId 商铺id
     */
    public void setBusinessId(Integer businessId) {
        this.businessId = businessId;
    }

    /**
     * 获取子订单总价格
     *
     * @return prices - 子订单总价格
     */
    public BigDecimal getPrices() {
        return prices;
    }

    /**
     * 设置子订单总价格
     *
     * @param prices 子订单总价格
     */
    public void setPrices(BigDecimal prices) {
        this.prices = prices;
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
     * 获取创建时间
     *
     * @return create_time - 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间
     *
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
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

}