package com.zheng.service.impl;

import com.zheng.entity.SysRoleEntity;
import com.zheng.mapper.SysRoleEntityMapper;
import com.zheng.service.RoleService;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

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

    @Override
    public List<SysRoleEntity> selectAllRoles() {
        return roleEntityMapper.selectAllRoles();
    }

    @Override
    public List<SysRoleEntity> selecDataByPage(Map map,Integer start, Integer end) {
        Map parMap  =  new HashedMap();
        parMap.put("rolestart",start==null?0:start);
        parMap.put("roleend",end==null?10:end);
        if(!map.isEmpty()){
            parMap.putAll(map);
        }
        return roleEntityMapper.selectDataByPage(parMap);
    }
}
