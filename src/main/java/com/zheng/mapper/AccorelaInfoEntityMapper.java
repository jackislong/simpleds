package com.zheng.mapper;

import com.zheng.entity.AccorelaInfoEntity;

public interface AccorelaInfoEntityMapper {
    int deleteByPrimaryKey(Integer objid);

    int insert(AccorelaInfoEntity record);

    int insertSelective(AccorelaInfoEntity record);

    AccorelaInfoEntity selectByPrimaryKey(Integer objid);

    int updateByPrimaryKeySelective(AccorelaInfoEntity record);

    int updateByPrimaryKey(AccorelaInfoEntity record);
}