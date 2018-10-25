package com.zheng.mapper;

import com.zheng.entity.SysRoleEntity;

import java.util.List;
import java.util.Map;

public interface SysRoleEntityMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SysRoleEntity record);

    int insertSelective(SysRoleEntity record);

    SysRoleEntity selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SysRoleEntity record);

    int updateByPrimaryKey(SysRoleEntity record);


    List<SysRoleEntity> listRolesByUserId(Long  userid);

    List<SysRoleEntity> selectAllRoles();

    List<SysRoleEntity>  selectDataByPage(Map parMap);
}