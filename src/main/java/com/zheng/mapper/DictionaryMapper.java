package com.zheng.mapper;

import com.zheng.entity.DictionaryEntity;

import java.util.List;

public interface DictionaryMapper {
    int deleteByPrimaryKey(Integer objid);

    int insert(DictionaryEntity record);

    int insertSelective(DictionaryEntity record);

    DictionaryEntity selectByPrimaryKey(Integer objid);

    int updateByPrimaryKeySelective(DictionaryEntity record);

    int updateByPrimaryKey(DictionaryEntity record);

    List<DictionaryEntity>  selectDictionaryByKey(Integer  keyno);
}