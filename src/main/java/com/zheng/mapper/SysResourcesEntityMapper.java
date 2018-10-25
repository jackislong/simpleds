package com.zheng.mapper;

import com.zheng.entity.SysResourcesEntity;

import java.util.List;
import java.util.Map;

public interface SysResourcesEntityMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SysResourcesEntity record);

    int insertSelective(SysResourcesEntity record);

    SysResourcesEntity selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SysResourcesEntity record);

    int updateByPrimaryKey(SysResourcesEntity record);

    List<SysResourcesEntity> listUrlAndPermission();

    List<SysResourcesEntity> listAll();

    List<SysResourcesEntity> listByUserId(Long  userId);

    List<SysResourcesEntity> selectDataByPage(Map parMap);


}