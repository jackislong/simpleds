package com.zheng.mapper;

import com.zheng.entity.SysUserRoleEntity;

public interface SysUserRoleEntityMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SysUserRoleEntity record);

    int insertSelective(SysUserRoleEntity record);

    SysUserRoleEntity selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SysUserRoleEntity record);

    int updateByPrimaryKey(SysUserRoleEntity record);
}