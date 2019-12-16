package com.mt.sx.pojo.vo;

import com.mt.sx.pojo.SxRole;
import lombok.Data;

@Data
public class SxRoleVo extends SxRole {
    private Integer page;
    private Integer pageSize;
}
