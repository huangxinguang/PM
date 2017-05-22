package com.ectrip.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by huangxinguang on 2017/5/17.
 */
@Controller
public class IndexController {
    /**
     * 首页
     * @return
     */
    @RequestMapping(value = "/index.html",method = RequestMethod.GET)
    public String index() {
        return "index/index";
    }

    @RequestMapping(value = "/main.html",method = RequestMethod.GET)
    public String main() {
        return "index/main";
    }
}
