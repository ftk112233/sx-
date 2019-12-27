package com.mt.sx.pojo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "sx_business")
public class SxBusiness implements Serializable {
    /**
     * 卖家自增id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 卖家店铺名称
     */
    private String name;



    /**
     * 店铺logo
     */
    private String pic;

    /**
     * 店铺图片
     */
    private String url;

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
     * 店铺描述
     */
    private String description;

    /**
     * 更新者
     */
    @Column(name = "update_by")
    private byte[] updateBy;

    /**
     * 获取卖家自增id
     *
     * @return id - 卖家自增id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置卖家自增id
     *
     * @param id 卖家自增id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取卖家店铺名称
     *
     * @return name - 卖家店铺名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置卖家店铺名称
     *
     * @param name 卖家店铺名称
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }


    /**
     * 获取店铺logo
     *
     * @return pic - 店铺logo
     */
    public String getPic() {
        return pic;
    }

    /**
     * 设置店铺logo
     *
     * @param pic 店铺logo
     */
    public void setPic(String pic) {
        this.pic = pic == null ? null : pic.trim();
    }

    /**
     * 获取店铺图片
     *
     * @return url - 店铺图片
     */
    public String getUrl() {
        return url;
    }

    /**
     * 设置店铺图片
     *
     * @param url 店铺图片
     */
    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
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
     * 获取店铺描述
     *
     * @return description - 店铺描述
     */
    public String getDescription() {
        return description;
    }

    /**
     * 设置店铺描述
     *
     * @param description 店铺描述
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    /**
     * 获取更新者
     *
     * @return update_by - 更新者
     */
    public byte[] getUpdateBy() {
        return updateBy;
    }

    /**
     * 设置更新者
     *
     * @param updateBy 更新者
     */
    public void setUpdateBy(byte[] updateBy) {
        this.updateBy = updateBy;
    }
}