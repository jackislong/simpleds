package com.zheng.mapper;

import com.zheng.entity.CustInfoEntity;

import java.util.List;
import java.util.Map;

public interface CustInfoEntityMapper {
    int deleteByPrimaryKey(Integer objid);

    int insert(CustInfoEntity record);

    int insertSelective(CustInfoEntity record);

    CustInfoEntity selectByPrimaryKey(Integer objid);

    int updateByPrimaryKeySelective(CustInfoEntity record);

    int updateByPrimaryKey(CustInfoEntity record);

    List<CustInfoEntity> selectCustInfoByCertTypeAndCertNo(Map map);
}