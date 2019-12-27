package com.mt.sx.pojo.vo;

import com.mt.sx.pojo.SxUser;
import lombok.Data;

@Data
public class SxUserVo extends SxUser {
    private Integer page=1;
    private Integer pageSize=10;
}
