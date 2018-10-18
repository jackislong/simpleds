package com.zheng.controller;

import com.zheng.service.ResourcesService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


/**
 * describle
 *
 * @author Administrator
 * @date 2018-10-11.
 */
@Controller
@RequestMapping(value = "passport")
public class PassportController {

    @Autowired
    ResourcesService resourcesService;

    @RequestMapping(value = "/login")
    public String login() {
        return  "login";
    }

    @RequestMapping(value = "/dashboard")
    public String dashboard(){

        return "index";
    }
    /**
     * 登录
     *
     * @param username
     * @param password
     * @return
     */
    @PostMapping("/signin")
    public String submitLogin(@RequestParam(value = "userName") String username, @RequestParam(value = "password") String password, ModelMap modelMap) {
        UsernamePasswordToken token = new UsernamePasswordToken(username, password, true);
        //获取当前的Subject
        Subject currentUser = SecurityUtils.getSubject();
        try {
            // 在调用了login方法后,SecurityManager会收到AuthenticationToken,并将其发送给已配置的Realm执行必须的认证检查
            // 每个Realm都能在必要时对提交的AuthenticationTokens作出反应
            // 所以这一步在调用login(token)方法时,它会走到xxRealm.doGetAuthenticationInfo()方法中,具体验证方式详见此方法
             currentUser.login(token);
            return "index";
        } catch (Exception e) {
            token.clear();
            modelMap.addAttribute("error",e.getMessage());
           return  "login";

        }
    }
}
