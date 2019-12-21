package com.mt.sx.pojo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "sx_user")
public class SxUser implements Serializable {
    /**
     * 自增id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 用户名
     */
    private String username;


    /**
     * 类型 0:超级管理员 1:商家  2:买家
     */
    private Integer type;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 关联的用户或商家id
     */
    @Column(name = "relate_id")
    private Integer relateId;

    /**
     * 微信传递过来的开放id
     */
    @Column(name = "open_id")
    private Integer openId;

    /**
     * 微信的昵称
     */
    @Column(name = "nice_name")
    private String niceName;

    /**
     * 微信的头像链接
     */
    private String pic;

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
     * 获取用户名
     *
     * @return username - 用户名
     */
    public String getUsername() {
        return username;
    }

    /**
     * 设置用户名
     *
     * @param username 用户名
     */
    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }


    /**
     * 获取类型 0:超级管理员 1:商家  2:买家
     *
     * @return type - 类型 0:超级管理员 1:商家  2:买家
     */
    public Integer getType() {
        return type;
    }

    /**
     * 设置类型 0:超级管理员 1:商家  2:买家
     *
     * @param type 类型 0:超级管理员 1:商家  2:买家
     */
    public void setType(Integer type) {
        this.type = type;
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
     * 获取关联的用户或商家id
     *
     * @return relate_id - 关联的用户或商家id
     */
    public Integer getRelateId() {
        return relateId;
    }

    /**
     * 设置关联的用户或商家id
     *
     * @param relateId 关联的用户或商家id
     */
    public void setRelateId(Integer relateId) {
        this.relateId = relateId;
    }
}