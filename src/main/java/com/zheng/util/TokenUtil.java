package com.zheng.util;

import com.zheng.consts.SessionConst;
import com.zheng.entity.SysUserEntity;
import com.zheng.holder.RequestHolder;

import java.util.UUID;

/**
 * describle
 *
 * @author Administrator
 * @date 2018-10-23.
 */
public class TokenUtil {
    /**
     * 检查是否重复提交
     * @return
     */
    public  static   boolean  checkToken(String  token){
        SysUserEntity sysUserEntity = (SysUserEntity) RequestHolder.getSession().getAttribute(SessionConst.USER_SESSION_KEY);
        Object sessionToken = RequestHolder.getSession().getAttribute("token"+sysUserEntity.getId()) ;
        if(sessionToken == null || !token.equals(sessionToken.toString())){
            return false;
        }
        return   true;
    }

    /**
     * 移除token
     * @param
     */
    public static  void   removeToken(){
        SysUserEntity sysUserEntity = (SysUserEntity) RequestHolder.getSession().getAttribute(SessionConst.USER_SESSION_KEY);
        RequestHolder.getSession().removeAttribute("token"+sysUserEntity.getId());
    }

    /**
     * 创建token
     */
    public static String buildToke(){
        SysUserEntity  sysUserEntity = (SysUserEntity)RequestHolder.getSession().getAttribute(SessionConst.USER_SESSION_KEY);
        String token =UUID.randomUUID().toString();
        RequestHolder.getSession().setAttribute("token"+sysUserEntity.getId(),token);
        return token;
    }
}
