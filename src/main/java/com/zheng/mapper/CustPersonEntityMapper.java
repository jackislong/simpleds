package com.zheng.mapper;

import com.zheng.entity.CustPersonEntity;

public interface CustPersonEntityMapper {
    int deleteByPrimaryKey(Integer objid);

    int insert(CustPersonEntity record);

    int insertSelective(CustPersonEntity record);

    CustPersonEntity selectByPrimaryKey(Integer objid);

    int updateByPrimaryKeySelective(CustPersonEntity record);

    int updateByPrimaryKey(CustPersonEntity record);
}