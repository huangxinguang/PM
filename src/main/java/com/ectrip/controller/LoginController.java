package com.ectrip.controller;

import com.ectrip.base.BaseController;
import com.ectrip.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by huangxinguang on 2017/5/22 下午3:19.
 */
@Controller
public class LoginController extends BaseController {

    /**
     * 登陆页面
     * @return
     */
    @RequestMapping(value = "/login.html",method = RequestMethod.GET)
    public String login() {
        return "login";
    }

    /**
     * 登陆
     * @return
     */
    @RequestMapping(value = "/loginIn.do",method = RequestMethod.POST)
    public ModelAndView loginIn(@ModelAttribute("user") User user) {
        ModelAndView mav = getModelAndView();
        getSession().setAttribute("user",user.getUserName());
        mav.setViewName("redirect:index.html");
        return mav;
    }

    /**
     * 退出登陆
     * @return
     */
    @RequestMapping(value = "/loginOut.do",method = RequestMethod.POST)
    public ModelAndView loginOut() {
        ModelAndView mav = getModelAndView();
        getSession().removeAttribute("user");
        mav.setViewName("redirect:index.html");
        return mav;
    }
}
