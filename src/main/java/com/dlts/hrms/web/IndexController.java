package com.dlts.hrms.web;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dlts.hrms.entity.SysUser;
import com.dlts.hrms.service.UserService;

@Controller
@RequestMapping("index")
public class IndexController {


    @Autowired
    UserService userService;

    @RequestMapping("login")
    public String login(HttpSession session, SysUser user) {
        user = userService.login(user);
        if (user != null) {
            session.setAttribute("user", user);
            return "redirect:html/index/index.html";
        } else {
            return "redirect:/asdfasdfasd";
        }
    }


}
