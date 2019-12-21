package com.mt.sx.service;

import com.github.pagehelper.PageInfo;
import com.mt.sx.pojo.SxUser;
import com.mt.sx.pojo.vo.SxUserVo;

import java.util.List;

public interface SxUserService {
    SxUser findByName(String username);

    void insert(SxUser sxUser);

    void updateUser(SxUser sxUser);

    void delete(Integer id);

    void batchDelete(List<Integer> ids);

    void updatePwd(Integer id, String password);

    PageInfo<SxUser> list(Integer page,Integer pageSize,String username);
}
