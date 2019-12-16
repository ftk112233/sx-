package com.mt.sx.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Table;
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "sx_role_permission")
public class SxRolePermission {
    /**
     * 角色id
     */

    private Integer rid;

    /**
     * 权限id
     */
    private Integer pid;

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

    /**
     * 获取权限id
     *
     * @return pid - 权限id
     */
    public Integer getPid() {
        return pid;
    }

    /**
     * 设置权限id
     *
     * @param pid 权限id
     */
    public void setPid(Integer pid) {
        this.pid = pid;
    }
}