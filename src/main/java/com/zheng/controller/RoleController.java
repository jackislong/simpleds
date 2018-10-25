package com.zheng.controller;

import com.zheng.bean.PageBean;
import com.zheng.service.RoleService;
import com.zheng.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;

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

    @RequestMapping(value = "page")
    @ResponseBody
    public PageBean selectRoleByPageCount(@RequestParam(value = "currentPage" ,defaultValue = "1") Integer  page, @RequestParam(value = "pagesize",defaultValue = "5") Integer  pageSize){
        Integer  start = (page-1)*pageSize;
        /**
         * 数据总条数
         */
        List    pageCount = roleService.selecDataByPage(new HashMap<>(),start,Integer.MAX_VALUE);
        /**
         * 展示条数
         */
        List     resultList  =  roleService.selecDataByPage(new HashMap<>(),start,pageSize);
        return PageUtil.buildPageBean(page,resultList,pageSize,pageCount);
    }
}
