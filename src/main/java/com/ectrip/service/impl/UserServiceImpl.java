package com.ectrip.service.impl;

import com.ectrip.model.User;
import com.ectrip.service.UserService;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

/**
 * Created by huangxinguang on 2017/5/22 下午5:49.
 */
@Service
public class UserServiceImpl implements UserService {

    @Override
    public PageInfo<User> queryUserListPage(Integer pageNo,Integer pageSize,String userName) {
        return null;
    }

    @Override
    public void saveUser(User user) {

    }

    @Override
    public User queryUser(Integer userId) {
        return null;
    }

    @Override
    public boolean check(String userName, String password) {
        return false;
    }


    @Override
    public void deleteUser(Integer userId) {

    }
}
