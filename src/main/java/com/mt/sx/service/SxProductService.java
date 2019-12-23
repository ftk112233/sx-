package com.mt.sx.service;

import com.mt.sx.common.base.CommonPage;
import com.mt.sx.pojo.SxProduct;
import com.mt.sx.pojo.vo.SxProductVO;

import java.util.List;

public interface SxProductService {
    CommonPage<List<SxProduct>> list(Integer page, Integer pageSize, String name, String description);

    void insert(SxProduct sxProduct);

    void update(SxProduct sxProduct);

    void delete(Integer id);

    CommonPage findSellWell();

    CommonPage findBySpuId(Integer spuId, Integer page, Integer pageSize);

    CommonPage search(String name, Integer page, Integer pageSize);

    SxProduct findById(Integer id);

    void batchDelete(List<Integer> ids);


}
