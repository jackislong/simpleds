package com.zheng.mapper;

import com.zheng.entity.AccountBankInfoEntity;

public interface AccountBankInfoEntityMapper {
    int deleteByPrimaryKey(Integer objid);

    int insert(AccountBankInfoEntity record);

    int insertSelective(AccountBankInfoEntity record);

    AccountBankInfoEntity selectByPrimaryKey(Integer objid);

    int updateByPrimaryKeySelective(AccountBankInfoEntity record);

    int updateByPrimaryKey(AccountBankInfoEntity record);
}