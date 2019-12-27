package com.mt.sx.service;

import com.mt.sx.pojo.SxUser;

public interface SxUserService {
    SxUser findByName(String username);

    void insert(SxUser sxUser);
}
