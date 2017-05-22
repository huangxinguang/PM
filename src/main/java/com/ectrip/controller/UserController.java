package com.ectrip.controller;

import com.ectrip.base.BaseController;
import com.ectrip.model.User;
import com.ectrip.service.UserService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by huangxinguang on 2017/5/22 下午5:37.
 */
@Controller
@RequestMapping("/user")
public class UserController extends BaseController {

    @Autowired
    private UserService userService;

    /**
     * 用户列表
     * @param userName
     * @return
     */
    @RequestMapping(value = "/userList.html",method = RequestMethod.GET)
    public ModelAndView userList(Integer pageNo,String userName) {
        ModelAndView mav = getModelAndView();
        PageInfo<User> pageInfo = userService.queryUserListPage(pageNo,pageSize,userName);

        mav.addObject("pageInfo",pageInfo);
        mav.setViewName("user/userList");
        return mav;
    }

    /**
     * 添加用户页面
     * @return
     */
    @RequestMapping(value = "/addUser.html",method = RequestMethod.GET)
    public String addUserPage() {
        return "user/addUser";
    }

    /**
     * 编辑用户页面
     * @param userId
     * @return
     */
    @RequestMapping(value = "/editUser.html",method = RequestMethod.GET)
    public ModelAndView editUserPage(Integer userId) {
        ModelAndView mav = getModelAndView();
        User user = userService.queryUser(userId);
        mav.addObject("user",user);
        mav.setViewName("user/editUser");
        return mav;
    }

    /**
     * 保存用户
     * @param user
     * @return
     */
    @RequestMapping(value = "/saveUser.do",method = RequestMethod.POST)
    public ModelAndView saveUser(@ModelAttribute("user") User user) {
        ModelAndView mav = getModelAndView();
        userService.saveUser(user);
        mav.setViewName("redirect:userList.html");
        return mav;
    }

    /**
     * 删除用户
     * @param userId
     * @return
     */
    @RequestMapping(value = "/delUser.do",method = RequestMethod.GET)
    public ModelAndView delUser(Integer userId) {
        ModelAndView mav = getModelAndView();
        userService.deleteUser(userId);
        mav.setViewName("redirect:userList.html");
        return mav;
    }
}
