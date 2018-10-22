package com.zheng.mapper;

import com.zheng.entity.CustPassWordEntity;

public interface CustPassWordEntityMapper {
    int deleteByPrimaryKey(Integer objid);

    int insert(CustPassWordEntity record);

    int insertSelective(CustPassWordEntity record);

    CustPassWordEntity selectByPrimaryKey(Integer objid);

    int updateByPrimaryKeySelective(CustPassWordEntity record);

    int updateByPrimaryKey(CustPassWordEntity record);
}