package com.ectrip.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by starlight on 2017/5/17.
 */
@Controller
public class IndexController {

    @RequestMapping(value = "/index.html",method = RequestMethod.GET)
    public String index() {
        return "index";
    }

    @RequestMapping(value = "/main.html",method = RequestMethod.GET)
    public String main() {
        return "main";
    }
}
