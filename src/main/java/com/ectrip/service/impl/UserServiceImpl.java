package com.ectrip.service.impl;

import com.ectrip.dao.UserDAO;
import com.ectrip.model.User;
import com.ectrip.service.UserService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by huangxinguang on 2017/5/22 下午5:49.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    @Override
    public PageInfo<User> queryUserListPage(Integer pageNo,Integer pageSize,String userName) {
        List<User> userList = userDAO.findUserListPage(pageNo,pageSize,userName);
        return new PageInfo<>(userList);
    }

    @Override
    public void saveUser(User user) {
        userDAO.save(user);
    }

    @Override
    public User queryUser(Integer userId) {
        return userDAO.find(userId);
    }

    @Override
    public boolean check(String userName, String password) {
        User user = userDAO.findUserByName(userName);
        if(user != null) {
            if (user.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean exists(String userName) {
        User user = userDAO.findUserByName(userName);
        if(user != null) {
            return true;
        }
        return false;
    }


    @Override
    public void deleteUser(Integer userId) {
        userDAO.delete(userId);
    }
}
