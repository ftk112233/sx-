package com.mt.sx.pojo;

import javax.persistence.*;
import java.io.Serializable;

@Table(name = "sx_user_role")
public class SxUserRole implements Serializable {
    /**
     * 用户id
     */
    private Integer uid;

    /**
     * 角色id
     */
    private Integer rid;

    /**
     * 获取用户id
     *
     * @return uid - 用户id
     */
    public Integer getUid() {
        return uid;
    }

    /**
     * 设置用户id
     *
     * @param uid 用户id
     */
    public void setUid(Integer uid) {
        this.uid = uid;
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