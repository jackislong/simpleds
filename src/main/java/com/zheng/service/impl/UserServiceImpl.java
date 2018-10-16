package com.zheng.service.impl;

import com.zheng.entity.SysUserEntity;
import com.zheng.holder.RequestHolder;
import com.zheng.mapper.SysUserEntityMapper;
import com.zheng.service.UserService;
import com.zheng.util.IpUtil;
import com.zheng.util.PasswordUtil;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.List;

/**
 * describle
 *
 * @author Administrator
 * @date 2018-10-11.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    SysUserEntityMapper sysUserEntityMapper;
    @Override
    public List<SysUserEntity> listByRoleId(Long roleId) {
        return sysUserEntityMapper.listByRoleId(roleId);
    }

    @Override
    public SysUserEntity selectByPrimaryKey(Integer id) {
        return sysUserEntityMapper.selectByPrimaryKey(id);
    }

    @Override
    public SysUserEntity getByUserName(String username) {
        return sysUserEntityMapper.getByUserName(username);
    }

    @Override
    public SysUserEntity updateUserLastLoginInfo(SysUserEntity user) {
        if (user != null) {
            user.setLoginCount(user.getLoginCount() + 1);
            user.setLastLoginTime(new Date());
            user.setLastLoginIp(IpUtil.getRealIp(RequestHolder.getRequest()));
            user.setPassword(null);
            this.updateSelective(user);
        }

        return   user;
    }

    @Transactional(rollbackFor = Exception.class)
    public boolean updateSelective(SysUserEntity user) {
        Assert.notNull(user, "User不可为空！");
        user.setUpdateTime(new Date());
        if (!StringUtils.isEmpty(user.getPassword())) {
            try {
                user.setPassword(PasswordUtil.encrypt(user.getPassword(), user.getUsername()));
            } catch (Exception e) {
                throw new ExcessiveAttemptsException("加密失败！");
            }
        } else {
            user.setPassword(null);
        }
        return sysUserEntityMapper.updateByPrimaryKeySelective(user) > 0;
    }
}
