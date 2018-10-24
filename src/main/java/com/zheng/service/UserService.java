package com.zheng.service;

import com.zheng.entity.SysUserEntity;

import java.util.List;

/**
 * describle
 *
 * @author Administrator
 * @date 2018-10-11.
 */
public interface UserService {

    List<SysUserEntity> listByRoleId(Long roleId);

    SysUserEntity selectByPrimaryKey(Integer id );

    SysUserEntity getByUserName(String username);

    SysUserEntity updateUserLastLoginInfo(SysUserEntity user);

    /**
     * 查询所有用户
     * @return
     */
    List<SysUserEntity>  selectAllUser();
}
