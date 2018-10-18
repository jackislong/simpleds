package com.zheng.shiro;

import com.zheng.consts.SessionConst;
import com.zheng.entity.SysUserEntity;
import com.zheng.exception.SimpleException;
import com.zheng.service.ResourcesService;
import com.zheng.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import java.util.concurrent.TimeUnit;

/**
 * Shiro-密码输入错误的状态下重试次数的匹配管理
 *
 * @author Administrator
 * @date 2018-10-11.
 */
public class RetryLimitCredentialsMatcher extends CredentialsMatcher {

    /**
     * 用户登录次数计数  redisKey 前缀
     */
    private static final String SHIRO_LOGIN_COUNT = "shiro_login_count_";
    /**
     * 用户登录是否被锁定    一小时 redisKey 前缀
     */
    private static final String SHIRO_IS_LOCK = "shiro_is_lock_";

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    UserService userService;


    @Autowired
    ResourcesService resourcesService;

    @Override
    public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info) {
        Integer userId = (Integer) info.getPrincipals().getPrimaryPrincipal();
        SysUserEntity user = userService.selectByPrimaryKey(userId);
        String username = user.getUsername();
        // 访问一次，计数一次
        ValueOperations<String, String> opsForValue = redisTemplate.opsForValue();
        String loginCountKey = SHIRO_LOGIN_COUNT + username;
        String isLockKey = SHIRO_IS_LOCK + username;
        opsForValue.increment(loginCountKey, 1);

        if (redisTemplate.hasKey(isLockKey)) {
            throw new ExcessiveAttemptsException("帐号[" + username + "]已被禁止登录！");
        }

        // 计数大于5时，设置用户被锁定10秒钟
        String loginCount = String.valueOf(opsForValue.get(loginCountKey));
        int retryCount = (5 - Integer.parseInt(loginCount));
        if (retryCount <= 0) {
            opsForValue.set(isLockKey, "LOCK");
            redisTemplate.expire(isLockKey, 10, TimeUnit.MILLISECONDS);
            redisTemplate.expire(loginCountKey, 10, TimeUnit.MILLISECONDS);
            throw new ExcessiveAttemptsException("由于密码输入错误次数过多，帐号[" + username + "]已被禁止登录！");
        }

        boolean matches = super.doCredentialsMatch(token, info);
        if (!matches) {
            String msg = retryCount <= 0 ? "您的账号一小时内禁止登录！" : "您还剩" + retryCount + "次重试的机会";
            throw new ExcessiveAttemptsException(msg);
        }

        //清空登录计数
        redisTemplate.delete(loginCountKey);
        try {
            userService.updateUserLastLoginInfo(user);
        } catch (Exception e) {
            throw new SimpleException(e.getMessage());
        }
        // 当验证都通过后，把用户信息放在session里
        // 注：User必须实现序列化
        SecurityUtils.getSubject().getSession().setAttribute(SessionConst.USER_SESSION_KEY, user);
        /**
         * 菜单
         */
        SecurityUtils.getSubject().getSession().setAttribute(SessionConst.USER_RESOURCE_KEY, resourcesService.listByUserId(new Long(userId.toString())));
        return true;
    }
}
