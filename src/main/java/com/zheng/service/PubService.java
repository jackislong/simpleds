package com.zheng.service;

import com.zheng.entity.DictionaryEntity;

import java.util.List;

/**
 * describle
 *
 * @author Administrator
 * @date 2018-10-19.
 */
public interface PubService {
    /**
     * 根据keyNo查询字典
     * @param keyno
     * @return
     */
    List<DictionaryEntity>  selectDictByKeyNo(Integer keyno);
}
