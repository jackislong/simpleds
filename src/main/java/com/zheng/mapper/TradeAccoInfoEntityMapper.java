package com.zheng.mapper;

import com.zheng.entity.TradeAccoInfoEntity;

public interface TradeAccoInfoEntityMapper {
    int deleteByPrimaryKey(Integer objid);

    int insert(TradeAccoInfoEntity record);

    int insertSelective(TradeAccoInfoEntity record);

    TradeAccoInfoEntity selectByPrimaryKey(Integer objid);

    int updateByPrimaryKeySelective(TradeAccoInfoEntity record);

    int updateByPrimaryKey(TradeAccoInfoEntity record);
}