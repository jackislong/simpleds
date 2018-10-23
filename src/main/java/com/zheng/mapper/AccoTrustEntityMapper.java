package com.zheng.mapper;

import com.zheng.entity.AccoTrustEntity;

public interface AccoTrustEntityMapper {
    int deleteByPrimaryKey(Integer objid);

    int insert(AccoTrustEntity record);

    int insertSelective(AccoTrustEntity record);

    AccoTrustEntity selectByPrimaryKey(Integer objid);

    int updateByPrimaryKeySelective(AccoTrustEntity record);

    int updateByPrimaryKey(AccoTrustEntity record);
}