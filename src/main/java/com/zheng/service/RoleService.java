package com.zheng.service;

import com.zheng.entity.SysRoleEntity;

import java.util.List;
import java.util.Map;

/**
 * describle
 *
 * @author Administrator
 * @date 2018-10-11.
 */
public interface RoleService {
     List<SysRoleEntity> listRolesByUserId(Long id);

     List<SysRoleEntity> selectAllRoles();

     List<SysRoleEntity> selecDataByPage(Map parMap,Integer start, Integer end);
}
