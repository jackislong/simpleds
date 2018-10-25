package com.zheng.service;

import com.zheng.entity.SysResourcesEntity;

import java.util.List;
import java.util.Map;

/**
 * describle
 *
 * @author Administrator
 * @date 2018-10-11.
 */
public interface ResourcesService {

    List<SysResourcesEntity>   listUrlAndPermission();

    List<SysResourcesEntity>   listAll();
    List<SysResourcesEntity>   listByUserId(Long  id);

    List<SysResourcesEntity>   selectDataByPage(Map parMap,int  start,int  end);
}
