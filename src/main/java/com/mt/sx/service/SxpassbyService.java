package com.mt.sx.service;

import com.mt.sx.pojo.SxPassby;

import java.util.List;

public interface SxpassbyService {
    List<SxPassby> findByBusId(Integer businessid);

    Integer insert(SxPassby sxPassby);

    Integer update(SxPassby sxPassby);

}
