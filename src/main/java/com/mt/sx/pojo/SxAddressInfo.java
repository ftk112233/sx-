package com.mt.sx.pojo;

import javax.persistence.*;
import java.util.Date;

@Table(name = "sx_address_info")
public class SxAddressInfo {
    /**
     * 自增id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 地址
     */
    private String address;

    /**
     * 联系电话
     */
    private String telephone;

    /**
     * 姓名
     */
    private String name;

    /**
     * 买家id
     */
    @Column(name = "shop_id")
    private Integer shopId;

    /**
     * 添加者
     */
    @Column(name = "create_by")
    private String createBy;

    /**
     * 添加时间
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
     * 获取联系电话
     *
     * @return telephone - 联系电话
     */
    public String getTelephone() {
        return telephone;
    }

    /**
     * 设置联系电话
     *
     * @param telephone 联系电话
     */
    public void setTelephone(String telephone) {
        this.telephone = telephone == null ? null : telephone.trim();
    }

    /**
     * 获取姓名
     *
     * @return name - 姓名
     */
    public String getName() {
        return name;
    }

    /**
     * 设置姓名
     *
     * @param name 姓名
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
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