package com.dlts.hrms.domain.po.login;

import com.dlts.hrms.domain.entity.User;

import java.io.Serializable;

public class LoginPo implements Serializable {

    private User user;
    private String token;

    public LoginPo(User user, String token) {
        this.user = user;
        this.token = token;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }



}
