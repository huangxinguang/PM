package com.ectrip.controller;

import com.ectrip.base.BaseController;
import com.ectrip.model.User;
import com.ectrip.service.UserService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

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
    public String addUserPage(Model model) {
        model.addAttribute("user",new User());
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
    public ModelAndView saveUser(@ModelAttribute("user") @Validated User user,BindingResult result) {
        ModelAndView mav = getModelAndView();
        boolean exists = userService.exists(user.getUserName());
        if(exists) {
            result.addError(new FieldError("user","userName","用户名已经存在！"));
        }
        if(result.hasErrors()) {
            mav.setViewName("user/addUser");
            return mav;
        }
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

    /**
     * 解锁
     * @param userName
     * @param password
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/unLock.do",method = RequestMethod.POST)
    public Object unLock(String userName,String password) {
        boolean success = userService.check(userName,password);
        Map<String,Object> result  = new HashMap<String,Object>();
        result.put("success",success);
        return result;
    }
}
