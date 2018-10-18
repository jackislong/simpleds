package com.zheng.controller;

import com.zheng.consts.SessionConst;
import com.zheng.entity.SysResourcesEntity;
import com.zheng.entity.SysUserEntity;
import com.zheng.service.ResourcesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * describle
 *
 * @author Administrator
 * @date 2018-10-18.
 */
@Controller
@RequestMapping(value = "menu")
public class MenuController {

    @Autowired
    ResourcesService aesourcesService;

    @RequestMapping(value = "/getTreeByRole")
    @ResponseBody
    public List<SysResourcesEntity> getTreeByRole(HttpSession httpSession) {
        SysUserEntity userEntity = (SysUserEntity)httpSession.getAttribute(SessionConst.USER_SESSION_KEY);
        return  aesourcesService.listByUserId(new Long(userEntity.getId().toString()));
    }
}
