package com.mt.sx.pojo;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Table(name = "sx_permission")
public class SxPermission  implements Serializable {
    /**
     * 自增id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 父id
     */
    private Integer pid;

    /**
     * 权限类型[menu/permission]
     */
    private String type;

    /**
     * 标题
     */
    private String title;

    /**
     * 权限编码[只有type= permission才有 user:view]
     */
    private String percode;

    /**
     * 图标
     */
    private String icon;

    /**
     * 链接
     */
    private String href;

    private String target;

    /**
     * 排序码
     */
    private Integer sort;

    /**
     * 状态 1:可用  0:禁用
     */
    private Integer status;

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
     * 获取父id
     *
     * @return pid - 父id
     */
    public Integer getPid() {
        return pid;
    }

    /**
     * 设置父id
     *
     * @param pid 父id
     */
    public void setPid(Integer pid) {
        this.pid = pid;
    }

    /**
     * 获取权限类型[menu/permission]
     *
     * @return type - 权限类型[menu/permission]
     */
    public String getType() {
        return type;
    }

    /**
     * 设置权限类型[menu/permission]
     *
     * @param type 权限类型[menu/permission]
     */
    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    /**
     * 获取标题
     *
     * @return title - 标题
     */
    public String getTitle() {
        return title;
    }

    /**
     * 设置标题
     *
     * @param title 标题
     */
    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    /**
     * 获取权限编码[只有type= permission才有 user:view]
     *
     * @return percode - 权限编码[只有type= permission才有 user:view]
     */
    public String getPercode() {
        return percode;
    }

    /**
     * 设置权限编码[只有type= permission才有 user:view]
     *
     * @param percode 权限编码[只有type= permission才有 user:view]
     */
    public void setPercode(String percode) {
        this.percode = percode == null ? null : percode.trim();
    }

    /**
     * 获取图标
     *
     * @return icon - 图标
     */
    public String getIcon() {
        return icon;
    }

    /**
     * 设置图标
     *
     * @param icon 图标
     */
    public void setIcon(String icon) {
        this.icon = icon == null ? null : icon.trim();
    }

    /**
     * 获取链接
     *
     * @return href - 链接
     */
    public String getHref() {
        return href;
    }

    /**
     * 设置链接
     *
     * @param href 链接
     */
    public void setHref(String href) {
        this.href = href == null ? null : href.trim();
    }

    /**
     * @return target
     */
    public String getTarget() {
        return target;
    }

    /**
     * @param target
     */
    public void setTarget(String target) {
        this.target = target == null ? null : target.trim();
    }

    /**
     * 获取排序码
     *
     * @return sort - 排序码
     */
    public Integer getSort() {
        return sort;
    }

    /**
     * 设置排序码
     *
     * @param sort 排序码
     */
    public void setSort(Integer sort) {
        this.sort = sort;
    }

    /**
     * 获取状态 1:可用  0:禁用
     *
     * @return status - 状态 1:可用  0:禁用
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置状态 1:可用  0:禁用
     *
     * @param status 状态 1:可用  0:禁用
     */
    public void setStatus(Integer status) {
        this.status = status;
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
}