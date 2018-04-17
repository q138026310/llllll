package com.dlts.hrms.domain.po.login;

import com.dlts.hrms.domain.entity.User;

public class LoginPo {

    private User user;
    private String token;

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
