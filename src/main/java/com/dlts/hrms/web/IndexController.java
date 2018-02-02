package com.dlts.hrms.web;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dlts.hrms.cm.Response;
import com.dlts.hrms.cm.Result;
import com.dlts.hrms.entity.SysUser;
import com.dlts.hrms.service.IUserService;

@Controller
@RequestMapping("index")
public class IndexController {

	@Autowired
	IUserService userService;

	@ResponseBody
	@RequestMapping("login")
	public String login(HttpSession session, SysUser user) {
		Result bean = userService.login(user);
		if (bean.isSuccess()) {
			session.setAttribute("user", bean.getData());
		}
		return Response.body(bean);
	}

}
