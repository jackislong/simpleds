package com.zheng.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * describle
 *
 * @author Administrator
 * @date 2018-10-11.
 */
@Controller
@RequestMapping(value = "fund")
public class FundController {

    @RequestMapping(value = "/")
    public String login() {
        return  "/fund/fundinfo";
    }
}
