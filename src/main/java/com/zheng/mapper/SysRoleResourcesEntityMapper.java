package com.zheng.mapper;

import com.zheng.entity.SysRoleResourcesEntity;

public interface SysRoleResourcesEntityMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SysRoleResourcesEntity record);

    int insertSelective(SysRoleResourcesEntity record);

    SysRoleResourcesEntity selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SysRoleResourcesEntity record);

    int updateByPrimaryKey(SysRoleResourcesEntity record);
}