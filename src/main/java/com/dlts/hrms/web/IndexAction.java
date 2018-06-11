package com.dlts.hrms.web;

import javax.servlet.http.HttpSession;

import com.dlts.hrms.domain.cm.SecretKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dlts.hrms.domain.cm.Response;
import com.dlts.hrms.domain.cm.Unified;
import com.dlts.hrms.domain.po.login.LoginPo;
import com.dlts.hrms.domain.vo.login.LoginVo;
import com.dlts.hrms.service.impl.UserService;

@RestController
@RequestMapping("/index")
public class IndexAction {

    @Autowired
    UserService userService;

    @RequestMapping("/login")
    public String login(LoginVo loginVo, HttpSession session) {
        Unified<LoginPo> unified = userService.login(loginVo);
        if (unified.success()) {
            session.setAttribute(SecretKey.user, unified.getData());
        }
        return Response.body(unified);
    }

}
