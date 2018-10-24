package com.zheng.mapper;

import com.zheng.entity.SysUserEntity;

import java.util.List;

public interface SysUserEntityMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SysUserEntity record);

    int insertSelective(SysUserEntity record);

    SysUserEntity selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysUserEntity record);

    int updateByPrimaryKey(SysUserEntity record);

    List<SysUserEntity> listByRoleId(Long  id);

    SysUserEntity getByUserName(String username);

    List<SysUserEntity> selectAllUser();
}