package com.zheng.mapper;

import com.zheng.entity.DoprocessEntity;

public interface DoprocessEntityMapper {
    int deleteByPrimaryKey(Integer objid);

    int insert(DoprocessEntity record);

    int insertSelective(DoprocessEntity record);

    DoprocessEntity selectByPrimaryKey(Integer objid);

    int updateByPrimaryKeySelective(DoprocessEntity record);

    int updateByPrimaryKey(DoprocessEntity record);

    DoprocessEntity selectBySerialNo(Integer serialNo);


    DoprocessEntity selectByName(String serialName);
}