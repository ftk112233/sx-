package com.mt.sx.pojo;

import java.util.Date;
import javax.persistence.*;

@Table(name = "sx_passby")
public class SxPassby {
    /**
     * 配送人员自增id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 配送员姓名
     */
    private String name;

    /**
     * 配送员电话
     */
    private String telephone;

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
     * 更新者
     */
    @Column(name = "update_by")
    private String updateBy;

    /**
     * 更新时间
     */
    @Column(name = "update_time")
    private Date updateTime;

    /**
     * 店铺id
     */
    @Column(name = "business_id")
    private Integer businessId;

    /**
     * 0正常 1禁止
     */
    private Integer status;

    /**
     * 0正常 1删除
     */
    private Integer deleted;

    /**
     * 获取配送人员自增id
     *
     * @return id - 配送人员自增id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置配送人员自增id
     *
     * @param id 配送人员自增id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取配送员姓名
     *
     * @return name - 配送员姓名
     */
    public String getName() {
        return name;
    }

    /**
     * 设置配送员姓名
     *
     * @param name 配送员姓名
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 获取配送员电话
     *
     * @return telephone - 配送员电话
     */
    public String getTelephone() {
        return telephone;
    }

    /**
     * 设置配送员电话
     *
     * @param telephone 配送员电话
     */
    public void setTelephone(String telephone) {
        this.telephone = telephone == null ? null : telephone.trim();
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
     * 获取店铺id
     *
     * @return business_id - 店铺id
     */
    public Integer getBusinessId() {
        return businessId;
    }

    /**
     * 设置店铺id
     *
     * @param businessId 店铺id
     */
    public void setBusinessId(Integer businessId) {
        this.businessId = businessId;
    }

    /**
     * 获取0正常 1禁止
     *
     * @return status - 0正常 1禁止
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置0正常 1禁止
     *
     * @param status 0正常 1禁止
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 获取0正常 1删除
     *
     * @return deleted - 0正常 1删除
     */
    public Integer getDeleted() {
        return deleted;
    }

    /**
     * 设置0正常 1删除
     *
     * @param deleted 0正常 1删除
     */
    public void setDeleted(Integer deleted) {
        this.deleted = deleted;
    }
}