package com.zheng.service.impl;

import com.zheng.entity.SysResourcesEntity;
import com.zheng.mapper.SysResourcesEntityMapper;
import com.zheng.service.ResourcesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * describle
 *
 * @author Administrator
 * @date 2018-10-11.
 */
@Service
public class ResourcesServiceImpl implements ResourcesService {

    @Autowired
    SysResourcesEntityMapper resourcesEntityMapper;

    @Override
    public List<SysResourcesEntity> listUrlAndPermission() {
        return resourcesEntityMapper.listUrlAndPermission();
    }

    @Override
    public List<SysResourcesEntity> listAll() {
        return resourcesEntityMapper.listAll();
    }

    @Override
    public List<SysResourcesEntity> listByUserId(Long id) {
        return resourcesEntityMapper.listByUserId(id);
    }
}
