package com.mt.sx.pojo;

import javax.persistence.*;

@Table(name = "sx_business")
public class SxBusiness {
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
     * 商户密码
     */
    private String password;

    /**
     * 店铺logo
     */
    private String pic;

    /**
     * 店铺图片
     */
    private String url;

    /**
     * 店铺描述
     */
    private String description;

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
     * 获取商户密码
     *
     * @return password - 商户密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置商户密码
     *
     * @param password 商户密码
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
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
}