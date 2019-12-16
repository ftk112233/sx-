package com.mt.sx.service;

import com.mt.sx.pojo.SxAddressInfo;

import java.util.List;

public interface SxUserAddressService {
    List<SxAddressInfo> addressList(Integer shopId);

    Integer insert(SxAddressInfo sxAddressInfo);

    Integer update(SxAddressInfo sxAddressInfo);

    Integer deletedForUser(Integer id);
}
