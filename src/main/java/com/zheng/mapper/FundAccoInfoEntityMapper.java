package com.zheng.mapper;

import com.zheng.entity.FundAccoInfoEntity;

import java.util.List;
import java.util.Map;

public interface FundAccoInfoEntityMapper {
    int deleteByPrimaryKey(Integer objid);

    int insert(FundAccoInfoEntity record);

    int insertSelective(FundAccoInfoEntity record);

    FundAccoInfoEntity selectByPrimaryKey(Integer objid);

    int updateByPrimaryKeySelective(FundAccoInfoEntity record);

    int updateByPrimaryKey(FundAccoInfoEntity record);

    List<FundAccoInfoEntity>   selectFundAccoInfoByTradeAccoAndTaCode(Map map);
}