package com.mt.sx.pojo;

import javax.persistence.Table;

@Table(name = "sx_business_role")
public class SxBusinessRole {
    /**
     * 商户id
     */
    private Integer bid;

    /**
     * 角色id
     */
    private Integer rid;

    /**
     * 获取商户id
     *
     * @return bid - 商户id
     */
    public Integer getBid() {
        return bid;
    }

    /**
     * 设置商户id
     *
     * @param bid 商户id
     */
    public void setBid(Integer bid) {
        this.bid = bid;
    }

    /**
     * 获取角色id
     *
     * @return rid - 角色id
     */
    public Integer getRid() {
        return rid;
    }

    /**
     * 设置角色id
     *
     * @param rid 角色id
     */
    public void setRid(Integer rid) {
        this.rid = rid;
    }
}