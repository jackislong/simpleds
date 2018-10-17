package com.zheng.shiro;

import com.zheng.consts.UserStatusEnum;
import com.zheng.consts.UserTypeEnum;
import com.zheng.entity.SysResourcesEntity;
import com.zheng.entity.SysRoleEntity;
import com.zheng.entity.SysUserEntity;
import com.zheng.service.ResourcesService;
import com.zheng.service.RoleService;
import com.zheng.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 *Shiro-密码输入错误的状态下重试次数的匹配管理
 * @author Administrator
 * @date 2018-10-11.
 */
public class ShiroRealm extends AuthorizingRealm {


    @Autowired
    UserService userService;

    @Autowired
    RoleService roleService;

    @Autowired
    ResourcesService resourcesService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {

        // 权限信息对象info,用来存放查出的用户的所有的角色（role）及权限（permission）
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();

        Integer userId =  (Integer) SecurityUtils.getSubject().getPrincipal();

        // 赋予角色
        List<SysRoleEntity> roleList = roleService.listRolesByUserId(new Long(userId.toString()));
        for (SysRoleEntity role : roleList) {
            info.addRole(role.getName());
        }

        // 赋予权限
        List<SysResourcesEntity> resourcesList = null;
        SysUserEntity user = userService.selectByPrimaryKey(new Integer(userId.toString()));
        if (null == user) {
            return info;
        }
        // ROOT用户默认拥有所有权限
        if (UserTypeEnum.ROOT.toString().equalsIgnoreCase(user.getUserType())) {
            resourcesList = resourcesService.listAll();
        } else {
            resourcesList = resourcesService.listByUserId(new Long(userId.toString()));
        }

        if (!CollectionUtils.isEmpty(resourcesList)) {
            Set<String> permissionSet = new HashSet<>();
            for (SysResourcesEntity resources : resourcesList) {
                String permission = null;
                if (!StringUtils.isEmpty(permission = resources.getPermission())) {
                    permissionSet.addAll(Arrays.asList(permission.trim().split(",")));
                }
            }
            info.setStringPermissions(permissionSet);
        }
        return info;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {

        //获取用户的输入的账号.
        String username = (String) token.getPrincipal();
        SysUserEntity user = userService.getByUserName(username);
        if (user == null) {
            throw new UnknownAccountException("账号不存在！");
        }
        if (user.getStatus() != null && UserStatusEnum.DISABLE.getCode().equals(user.getStatus())) {
            throw new LockedAccountException("帐号已被锁定，禁止登录！");
        }

        // principal参数使用用户Id，方便动态刷新用户权限
        return new SimpleAuthenticationInfo(
                user.getId(),
                user.getPassword(),
                ByteSource.Util.bytes(username),
                getName()
        );

    }
}
