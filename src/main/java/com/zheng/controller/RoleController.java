package com.zheng.controller;

import com.zheng.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * describle
 *
 * @author Administrator
 * @date 2018-10-24.
 */
@Controller
@RequestMapping(value = "roles")
public class RoleController {

    @Autowired
    RoleService roleService;

    @RequestMapping(value = "list")
    public String list(ModelMap modelMap){
        modelMap.put("rolelist",roleService.selectAllRoles());
        return "role/rolelist";
    }
}
