package com.dlts.hrms.web;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dlts.hrms.cm.App;
import com.dlts.hrms.cm.LoginResult;
import com.dlts.hrms.cm.Response;
import com.dlts.hrms.entity.SysUser;
import com.dlts.hrms.service.IUserService;
import com.dlts.hrms.web.base.BaseController;

@Controller
@RequestMapping("index")
public class IndexController extends BaseController {

    @Resource(name = "userService")
    IUserService userService;

    @ResponseBody
    @RequestMapping("login")
    public String login(HttpSession session, SysUser user) {
        LoginResult bean = userService.login(user);
        if (bean.isSuccess()) {
            session.setAttribute("user", bean.getUser());
            session.setAttribute("company", bean.getCompany());
        }
        return Response.body(bean.getUser());
    }

    @ResponseBody
    @RequestMapping(value = "cont")
    public String cont() {
        return App.CONT;
    }

}
