package com.zheng.controller;

import com.zheng.entity.SysResourcesEntity;
import com.zheng.service.ResourcesService;
import com.zheng.util.EntityUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
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
        List resultList = new ArrayList<>();
        List<SysResourcesEntity> list = resourcesService.listAll();
        for(int i= list.size()-1;i>0;i--){
            SysResourcesEntity o =  list.get(i);
            resultList.add(EntityUtil.objectToMap(o));
        }
        modelMap.put("resourcelist",resultList);
        return "/resource/resourcelist";
    }
}
