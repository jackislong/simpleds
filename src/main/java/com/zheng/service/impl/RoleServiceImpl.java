package com.zheng.service.impl;

import com.zheng.entity.SysRoleEntity;
import com.zheng.mapper.SysResourcesEntityMapper;
import com.zheng.mapper.SysRoleEntityMapper;
import com.zheng.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * describle
 *
 * @author Administrator
 * @date 2018-10-11.
 */
@Service
public class RoleServiceImpl  implements RoleService {

    @Autowired
    SysRoleEntityMapper roleEntityMapper;

    @Override
    @Transactional(readOnly = true)
    public List<SysRoleEntity> listRolesByUserId(Long id) {
        return roleEntityMapper.listRolesByUserId(id);
    }
}
