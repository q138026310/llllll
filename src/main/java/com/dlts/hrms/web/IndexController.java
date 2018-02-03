package com.dlts.hrms.web;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dlts.hrms.cm.Response;
import com.dlts.hrms.cm.Result;
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
        Result bean = userService.login(user);
        if (bean.isSuccess()) {
            session.setAttribute("user", bean.getData());
        }
        return Response.body(bean.getData());
    }

}
