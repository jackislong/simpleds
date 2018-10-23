package com.zheng.controller;

import com.zheng.business.AccountBIZService;
import com.zheng.service.PubService;
import com.zheng.util.TokenUtil;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.collections.map.CaseInsensitiveMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
    public String account(HttpServletRequest  request,ModelMap modelMap) {
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

        modelMap.put("token",TokenUtil.buildToke());
        return  "/account/account";
    }

    @RequestMapping(value = "/openaccount")
    public String openaccount(HttpServletRequest  request, ModelMap modelMap, @RequestParam(value = "token") String   token){
        /**
         * token 防止重复提交
         */
//        if(!TokenUtil.checkToken(token)){
//            return "redirect:/account/";
//        }
        CaseInsensitiveMap parmMap =  new CaseInsensitiveMap(34);
        Iterator iterator =  request.getParameterMap().keySet().iterator();
        while (iterator.hasNext()){
            String key = (String)iterator.next();
            Object  value = request.getParameter(key);
            parmMap.put(key,value);
        }
        String requestDateBean= MapUtils.getString(parmMap,"requesttime","");
        String brithday = MapUtils.getString(parmMap,"birthday","");
        String eff = MapUtils.getString(parmMap,"eff","");
        String requestDate = requestDateBean.substring(0,10).replace("-","");
        String requestTime = requestDateBean.substring(11,19).replace(":","");
        parmMap.put("requestDate",requestDate);
        parmMap.put("requestTime",requestTime);
        parmMap.put("birthday",brithday.substring(0,10).replace("-",""));
        if(!org.springframework.util.StringUtils.isEmpty(eff) && "on".equals(eff)) {
            parmMap.put("timelimited","99999999");
        }else{
            parmMap.put("timelimited",parmMap.get("timelimit"));
        }
        parmMap.put("tacode","28");
        accountbizService.openaccount(parmMap);
        modelMap.addAttribute("error","开户成功");
        TokenUtil.removeToken();
        return "redirect:/account/";
    }
}
