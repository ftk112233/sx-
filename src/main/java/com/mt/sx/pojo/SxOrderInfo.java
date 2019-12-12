package com.mt.sx.pojo;

import java.util.Date;
import javax.persistence.*;

@Table(name = "sx_order_info")
public class SxOrderInfo {
    /**
     * 订单详情id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 总订单id
     */
    @Column(name = "order_id")
    private String orderId;

    /**
     * 子订单id
     */
    @Column(name = "suborder_id")
    private String suborderId;

    /**
     * 商品id
     */
    @Column(name = "product_id")
    private Integer productId;

    /**
     * 当前商品数量
     */
    private Integer number;

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
     * 状态 0正常 1隐藏
     */
    private Integer status;

    /**
     * 删除 0正常 1删除
     */
    private Integer deleted;

    /**
     * 0 未支付 1 已支付 2 已发货 3 已签收
     */
    private Integer type;

    /**
     * 获取订单详情id
     *
     * @return id - 订单详情id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置订单详情id
     *
     * @param id 订单详情id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取总订单id
     *
     * @return order_id - 总订单id
     */
    public String getOrderId() {
        return orderId;
    }

    /**
     * 设置总订单id
     *
     * @param orderId 总订单id
     */
    public void setOrderId(String orderId) {
        this.orderId = orderId == null ? null : orderId.trim();
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
     * 获取当前商品数量
     *
     * @return number - 当前商品数量
     */
    public Integer getNumber() {
        return number;
    }

    /**
     * 设置当前商品数量
     *
     * @param number 当前商品数量
     */
    public void setNumber(Integer number) {
        this.number = number;
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
     * 获取状态 0正常 1隐藏
     *
     * @return status - 状态 0正常 1隐藏
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置状态 0正常 1隐藏
     *
     * @param status 状态 0正常 1隐藏
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 获取删除 0正常 1删除
     *
     * @return deleted - 删除 0正常 1删除
     */
    public Integer getDeleted() {
        return deleted;
    }

    /**
     * 设置删除 0正常 1删除
     *
     * @param deleted 删除 0正常 1删除
     */
    public void setDeleted(Integer deleted) {
        this.deleted = deleted;
    }

    /**
     * 获取0 未支付 1 已支付 2 已发货 3 已签收
     *
     * @return type - 0 未支付 1 已支付 2 已发货 3 已签收
     */
    public Integer getType() {
        return type;
    }

    /**
     * 设置0 未支付 1 已支付 2 已发货 3 已签收
     *
     * @param type 0 未支付 1 已支付 2 已发货 3 已签收
     */
    public void setType(Integer type) {
        this.type = type;
    }
}