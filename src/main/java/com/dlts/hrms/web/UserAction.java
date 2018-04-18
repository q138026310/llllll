package com.dlts.hrms.web;

import com.dlts.hrms.domain.cm.Response;
import com.dlts.hrms.domain.entity.BaseEntity;
import com.dlts.hrms.domain.entity.User;
import com.dlts.hrms.service.impl.UserService;
import com.dlts.hrms.utils.JsonUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserAction extends BaseAction{

    Logger logger = Logger.getLogger(getClass());

    @Autowired
    UserService userService;

    @RequestMapping("/insert")
    public String insert(User entity) {
        return Response.body(userService.insert(entity));
    }

    @RequestMapping("/update")
    public String update(User user) {
        return Response.body(userService.update(user));
    }

    @RequestMapping("/delete")
    public String delete(User user) {
        return Response.body(userService.delete(user));
    }

    @RequestMapping("/page")
    public String page() {
        return Response.body(userService.page());
    }

    @RequestMapping("/get")
    public String get(User user) {
        return Response.body(userService.get(user));
    }

}
