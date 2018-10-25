package com.zheng.controller;

import com.zheng.bean.PageBean;
import com.zheng.service.ResourcesService;
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
@RequestMapping(value = "resources")
@Controller
public class ResourceController {

    @Autowired
    ResourcesService  resourcesService;

    @RequestMapping(value = "list")
    public String resource(ModelMap  modelMap){
        return "/resource/resourcelist";
    }

    @RequestMapping(value = "page")
    @ResponseBody
    public PageBean selectRoleByPageCount(@RequestParam(value = "currentPage" ,defaultValue = "1") Integer  page, @RequestParam(value = "pagesize",defaultValue = "10") Integer  pageSize){
        Integer  start = (page-1)*pageSize;
        //数据总条数
        List dataCount = resourcesService.selectDataByPage(new HashMap<>(),0,Integer.MAX_VALUE);
        //展示条数
        List     resultList  =  resourcesService.selectDataByPage(new HashMap<>(),start,pageSize);
        return PageUtil.buildPageBean(page,resultList,pageSize,dataCount);
    }
}
