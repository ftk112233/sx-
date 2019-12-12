package com.mt.sx.pojo;

import java.util.Date;
import javax.persistence.*;

@Table(name = "sx_spu")
public class SxSpu {
    /**
     * 自增id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 商品集合名称
     */
    private String name;

    /**
     * 分类id
     */
    @Column(name = "category_id")
    private Integer categoryId;

    /**
     * 图片地址
     */
    private String pic;

    /**
     * 排序
     */
    private Integer sort;

    /**
     * 1:上架  0:下架
     */
    private Integer status;

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
     * 获取商品集合名称
     *
     * @return name - 商品集合名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置商品集合名称
     *
     * @param name 商品集合名称
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 获取分类id
     *
     * @return category_id - 分类id
     */
    public Integer getCategoryId() {
        return categoryId;
    }

    /**
     * 设置分类id
     *
     * @param categoryId 分类id
     */
    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
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
     * 获取1:上架  0:下架
     *
     * @return status - 1:上架  0:下架
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置1:上架  0:下架
     *
     * @param status 1:上架  0:下架
     */
    public void setStatus(Integer status) {
        this.status = status;
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
}