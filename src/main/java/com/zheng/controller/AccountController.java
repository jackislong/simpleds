package com.zheng.controller;

import com.zheng.business.AccountBIZService;
import com.zheng.entity.CustInfoEntity;
import com.zheng.service.PubService;
import com.zheng.util.EntityUtil;
import org.apache.commons.collections.map.CaseInsensitiveMap;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Iterator;


/**
 * describle
 * @author Administrator
 *
 * @date 2018-10-11.
 */
@Controller
@RequestMapping(value = "account")
public class AccountController {

    @Autowired
    PubService  pubService;

    @Autowired
    AccountBIZService accountbizService;

    @RequestMapping(value = "/")
    public String account(ModelMap modelMap) {
        /**
         * 证件类型
         */
        modelMap.addAttribute("certtypelist",pubService.selectDictByKeyNo(1018));
        /**
         * 对账单邮寄方式         */
        modelMap.addAttribute("billtypelist",pubService.selectDictByKeyNo(1016));
        /**
         * 对账单邮寄途径
         */
        modelMap.addAttribute("billwaylist",pubService.selectDictByKeyNo(1069));
        /**
         * 银行名称
         */
        modelMap.addAttribute("banklist",pubService.selectDictByKeyNo(1014));
        /**
         * 行业
         */
        modelMap.addAttribute("tradelist",pubService.selectDictByKeyNo(1024));
        /**
         * 职业
         */
        modelMap.addAttribute("vocationlist",pubService.selectDictByKeyNo(1021));
        /**
         * 年收入
         */
        modelMap.addAttribute("incomelist",pubService.selectDictByKeyNo(1056));
        /**
         * 婚姻
         */
        modelMap.addAttribute("marrylist",pubService.selectDictByKeyNo(1022));
        return  "/account/account";
    }

    @RequestMapping(value = "/openaccount")
    public String openaccount(HttpServletRequest  request,ModelMap modelMap){
        CaseInsensitiveMap parmMap =  new CaseInsensitiveMap(34);
        Iterator iterator =  request.getParameterMap().keySet().iterator();
        while (iterator.hasNext()){
            String key = (String)iterator.next();
            Object  value = request.getParameter(key);
            parmMap.put(key,value);
        }
        accountbizService.openaccount(parmMap);
        modelMap.addAttribute("error","开户成功");
        return "redirect:/account/";
    }
}
