package com.zheng.controller;

import com.zheng.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * describle
 *
 * @author Administrator
 * @date 2018-10-24.
 */
@RequestMapping(value = "/user")
@Controller
public class UserController {


    @Autowired
    UserService  userService;

    @RequestMapping(value = "users")
    public String  user(ModelMap  modelMap){
        modelMap.put("userlist",userService.selectAllUser());
        return "/user/alluser";
    }


    @RequestMapping(value = "userDetails")
    public  String userDetails(@RequestParam(value = "userid") Integer  id ,ModelMap modelMap){
        modelMap.put("user",userService.selectByPrimaryKey(id));
        return "/user/userManage";
    }


}
