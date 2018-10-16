package com.zheng.service;

import com.zheng.entity.SysRoleEntity;

import java.util.List;

/**
 * describle
 *
 * @author Administrator
 * @date 2018-10-11.
 */
public interface RoleService {
     List<SysRoleEntity> listRolesByUserId(Long id);
}
