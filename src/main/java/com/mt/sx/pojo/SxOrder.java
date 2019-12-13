package com.mt.sx.pojo;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Table(name = "sx_order")
public class SxOrder {
    /**
     * 订单id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    /**
     * 用户的id（商家）
     */
    @Column(name = "shop_id")
    private Integer shopId;

    /**
     * 商品总件数
     */
    @Column(name = "total_number")
    private Integer totalNumber;

    /**
     * 总价格
     */
    @Column(name = "total_price")
    private BigDecimal totalPrice;

    /**
     * 0 未支付 1 已支付 2 已发货 3 已签收
     */
    private Integer type;

    /**
     * 生成时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 用户期望送达时间
     */
    @Column(name = "hope_time")
    private Date hopeTime;

    /**
     * 订单信息0正常1隐藏
     */
    private Integer status;

    /**
     * 是否删除0正常1隐藏
     */
    private Integer deleted;

    /**
     * 更新时间
     */
    @Column(name = "update_time")
    private Date updateTime;

    /**
     * 地址
     */
    private String address;

    /**
     * 买家留言
     */
    private String message;

    /**
     * 配送人员id
     */
    @Column(name = "passby_id")
    private Integer passbyId;

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
     * 微信支付返回的交易单号
     */
    @Column(name = "transaction_id")
    private String transactionId;

    /**
     * 获取订单id
     *
     * @return id - 订单id
     */
    public String getId() {
        return id;
    }

    /**
     * 设置订单id
     *
     * @param id 订单id
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * 获取用户的id（商家）
     *
     * @return shop_id - 用户的id（商家）
     */
    public Integer getShopId() {
        return shopId;
    }

    /**
     * 设置用户的id（商家）
     *
     * @param shopId 用户的id（商家）
     */
    public void setShopId(Integer shopId) {
        this.shopId = shopId;
    }

    /**
     * 获取商品总件数
     *
     * @return total_number - 商品总件数
     */
    public Integer getTotalNumber() {
        return totalNumber;
    }

    /**
     * 设置商品总件数
     *
     * @param totalNumber 商品总件数
     */
    public void setTotalNumber(Integer totalNumber) {
        this.totalNumber = totalNumber;
    }

    /**
     * 获取总价格
     *
     * @return total_price - 总价格
     */
    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    /**
     * 设置总价格
     *
     * @param totalPrice 总价格
     */
    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
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

    /**
     * 获取生成时间
     *
     * @return create_time - 生成时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置生成时间
     *
     * @param createTime 生成时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取用户期望送达时间
     *
     * @return hope_time - 用户期望送达时间
     */
    public Date getHopeTime() {
        return hopeTime;
    }

    /**
     * 设置用户期望送达时间
     *
     * @param hopeTime 用户期望送达时间
     */
    public void setHopeTime(Date hopeTime) {
        this.hopeTime = hopeTime;
    }

    /**
     * 获取订单信息0正常1隐藏
     *
     * @return status - 订单信息0正常1隐藏
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置订单信息0正常1隐藏
     *
     * @param status 订单信息0正常1隐藏
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 获取是否删除0正常1隐藏
     *
     * @return deleted - 是否删除0正常1隐藏
     */
    public Integer getDeleted() {
        return deleted;
    }

    /**
     * 设置是否删除0正常1隐藏
     *
     * @param deleted 是否删除0正常1隐藏
     */
    public void setDeleted(Integer deleted) {
        this.deleted = deleted;
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
     * 获取地址
     *
     * @return address - 地址
     */
    public String getAddress() {
        return address;
    }

    /**
     * 设置地址
     *
     * @param address 地址
     */
    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    /**
     * 获取买家留言
     *
     * @return message - 买家留言
     */
    public String getMessage() {
        return message;
    }

    /**
     * 设置买家留言
     *
     * @param message 买家留言
     */
    public void setMessage(String message) {
        this.message = message == null ? null : message.trim();
    }

    /**
     * 获取配送人员id
     *
     * @return passby_id - 配送人员id
     */
    public Integer getPassbyId() {
        return passbyId;
    }

    /**
     * 设置配送人员id
     *
     * @param passbyId 配送人员id
     */
    public void setPassbyId(Integer passbyId) {
        this.passbyId = passbyId;
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
     * 获取微信支付返回的交易单号
     *
     * @return transaction_id - 微信支付返回的交易单号
     */
    public String getTransactionId() {
        return transactionId;
    }

    /**
     * 设置微信支付返回的交易单号
     *
     * @param transactionId 微信支付返回的交易单号
     */
    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId == null ? null : transactionId.trim();
    }
}