package com.ectrip.model;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 * Created by huangxinguang on 2017/5/22 下午4:38.
 */
public class User {

    private Integer id;

    @NotBlank(message="用户名不能为空")
    private String userName;

    @NotBlank(message="密码不能为空")
    @Length(min=6,message="密码长度不能小于6位")
    private String password;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
