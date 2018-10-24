package com.zheng.mapper;

import com.zheng.entity.AccountBankBindEntity;

public interface AccountBankBindEntityMapper {
    int deleteByPrimaryKey(Integer objid);

    int insert(AccountBankBindEntity record);

    int insertSelective(AccountBankBindEntity record);

    AccountBankBindEntity selectByPrimaryKey(Integer objid);

    int updateByPrimaryKeySelective(AccountBankBindEntity record);

    int updateByPrimaryKey(AccountBankBindEntity record);
}