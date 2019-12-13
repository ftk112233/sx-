package com.mt.sx.pojo;

import javax.persistence.*;
import java.util.Date;

@Table(name = "ys_shop")
public class YsShop {
    /**
     * 自增id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 商家名称
     */
    @Column(name = "shop_name")
    private String shopName;

    /**
     * 添加时间
     */
    @Column(name = "add_time")
    private Date addTime;

    /**
     * 状态
     */
    private Integer status;

    /**
     * 商家地址
     */
    private String address;

    /**
     * 营业开始时间
     */
    @Column(name = "begin_time")
    private Date beginTime;

    /**
     * 营业结束时间
     */
    @Column(name = "end_time")
    private Date endTime;

    /**
     * 电话号码
     */
    private String phone;

    /**
     * 图片地址
     */
    @Column(name = "img_url")
    private String imgUrl;

    /**
     * 商家logo
     */
    @Column(name = "shop_logo")
    private String shopLogo;

    /**
     * 商家简介
     */
    @Column(name = "shop_desc")
    private String shopDesc;

    /**
     * 是否营业
     */
    @Column(name = "open_status")
    private Integer openStatus;

    /**
     * 分类id
     */
    @Column(name = "style_id")
    private Integer styleId;

    /**
     * 流地址
     */
    @Column(name = "shop_flow")
    private String shopFlow;

    /**
     * 纬度
     */
    private String lat;

    /**
     * 经度
     */
    private String lng;

    /**
     * 关联region表
     */
    @Column(name = "region_id")
    private Integer regionId;

    /**
     * 营业执照
     */
    @Column(name = "charter_img")
    private String charterImg;

    /**
     * 健康证
     */
    @Column(name = "health_img")
    private String healthImg;

    /**
     * 店内环境
     */
    @Column(name = "surroundings_img")
    private String surroundingsImg;

    /**
     * 类型
     */
    private Integer type;

    /**
     * 审核
     */
    private Integer review;

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
     * 获取商家名称
     *
     * @return shop_name - 商家名称
     */
    public String getShopName() {
        return shopName;
    }

    /**
     * 设置商家名称
     *
     * @param shopName 商家名称
     */
    public void setShopName(String shopName) {
        this.shopName = shopName == null ? null : shopName.trim();
    }

    /**
     * 获取添加时间
     *
     * @return add_time - 添加时间
     */
    public Date getAddTime() {
        return addTime;
    }

    /**
     * 设置添加时间
     *
     * @param addTime 添加时间
     */
    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    /**
     * 获取状态
     *
     * @return status - 状态
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置状态
     *
     * @param status 状态
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 获取商家地址
     *
     * @return address - 商家地址
     */
    public String getAddress() {
        return address;
    }

    /**
     * 设置商家地址
     *
     * @param address 商家地址
     */
    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    /**
     * 获取营业开始时间
     *
     * @return begin_time - 营业开始时间
     */
    public Date getBeginTime() {
        return beginTime;
    }

    /**
     * 设置营业开始时间
     *
     * @param beginTime 营业开始时间
     */
    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }

    /**
     * 获取营业结束时间
     *
     * @return end_time - 营业结束时间
     */
    public Date getEndTime() {
        return endTime;
    }

    /**
     * 设置营业结束时间
     *
     * @param endTime 营业结束时间
     */
    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    /**
     * 获取电话号码
     *
     * @return phone - 电话号码
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 设置电话号码
     *
     * @param phone 电话号码
     */
    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    /**
     * 获取图片地址
     *
     * @return img_url - 图片地址
     */
    public String getImgUrl() {
        return imgUrl;
    }

    /**
     * 设置图片地址
     *
     * @param imgUrl 图片地址
     */
    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl == null ? null : imgUrl.trim();
    }

    /**
     * 获取商家logo
     *
     * @return shop_logo - 商家logo
     */
    public String getShopLogo() {
        return shopLogo;
    }

    /**
     * 设置商家logo
     *
     * @param shopLogo 商家logo
     */
    public void setShopLogo(String shopLogo) {
        this.shopLogo = shopLogo == null ? null : shopLogo.trim();
    }

    /**
     * 获取商家简介
     *
     * @return shop_desc - 商家简介
     */
    public String getShopDesc() {
        return shopDesc;
    }

    /**
     * 设置商家简介
     *
     * @param shopDesc 商家简介
     */
    public void setShopDesc(String shopDesc) {
        this.shopDesc = shopDesc == null ? null : shopDesc.trim();
    }

    /**
     * 获取是否营业
     *
     * @return open_status - 是否营业
     */
    public Integer getOpenStatus() {
        return openStatus;
    }

    /**
     * 设置是否营业
     *
     * @param openStatus 是否营业
     */
    public void setOpenStatus(Integer openStatus) {
        this.openStatus = openStatus;
    }

    /**
     * 获取分类id
     *
     * @return style_id - 分类id
     */
    public Integer getStyleId() {
        return styleId;
    }

    /**
     * 设置分类id
     *
     * @param styleId 分类id
     */
    public void setStyleId(Integer styleId) {
        this.styleId = styleId;
    }

    /**
     * 获取流地址
     *
     * @return shop_flow - 流地址
     */
    public String getShopFlow() {
        return shopFlow;
    }

    /**
     * 设置流地址
     *
     * @param shopFlow 流地址
     */
    public void setShopFlow(String shopFlow) {
        this.shopFlow = shopFlow == null ? null : shopFlow.trim();
    }

    /**
     * 获取纬度
     *
     * @return lat - 纬度
     */
    public String getLat() {
        return lat;
    }

    /**
     * 设置纬度
     *
     * @param lat 纬度
     */
    public void setLat(String lat) {
        this.lat = lat == null ? null : lat.trim();
    }

    /**
     * 获取经度
     *
     * @return lng - 经度
     */
    public String getLng() {
        return lng;
    }

    /**
     * 设置经度
     *
     * @param lng 经度
     */
    public void setLng(String lng) {
        this.lng = lng == null ? null : lng.trim();
    }

    /**
     * 获取关联region表
     *
     * @return region_id - 关联region表
     */
    public Integer getRegionId() {
        return regionId;
    }

    /**
     * 设置关联region表
     *
     * @param regionId 关联region表
     */
    public void setRegionId(Integer regionId) {
        this.regionId = regionId;
    }

    /**
     * 获取营业执照
     *
     * @return charter_img - 营业执照
     */
    public String getCharterImg() {
        return charterImg;
    }

    /**
     * 设置营业执照
     *
     * @param charterImg 营业执照
     */
    public void setCharterImg(String charterImg) {
        this.charterImg = charterImg == null ? null : charterImg.trim();
    }

    /**
     * 获取健康证
     *
     * @return health_img - 健康证
     */
    public String getHealthImg() {
        return healthImg;
    }

    /**
     * 设置健康证
     *
     * @param healthImg 健康证
     */
    public void setHealthImg(String healthImg) {
        this.healthImg = healthImg == null ? null : healthImg.trim();
    }

    /**
     * 获取店内环境
     *
     * @return surroundings_img - 店内环境
     */
    public String getSurroundingsImg() {
        return surroundingsImg;
    }

    /**
     * 设置店内环境
     *
     * @param surroundingsImg 店内环境
     */
    public void setSurroundingsImg(String surroundingsImg) {
        this.surroundingsImg = surroundingsImg == null ? null : surroundingsImg.trim();
    }

    /**
     * 获取类型
     *
     * @return type - 类型
     */
    public Integer getType() {
        return type;
    }

    /**
     * 设置类型
     *
     * @param type 类型
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * 获取审核
     *
     * @return review - 审核
     */
    public Integer getReview() {
        return review;
    }

    /**
     * 设置审核
     *
     * @param review 审核
     */
    public void setReview(Integer review) {
        this.review = review;
    }
}