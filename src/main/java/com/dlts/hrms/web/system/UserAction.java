package com.dlts.hrms.web.system;

import com.dlts.hrms.domain.cm.Response;
import com.dlts.hrms.domain.entity.User;
import com.dlts.hrms.service.impl.UserService;
import com.dlts.hrms.web.BaseAction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserAction extends BaseAction {

    Logger logger = LoggerFactory.getLogger(UserAction.class);

    @Autowired
    UserService userService;

    @RequestMapping("/insert")
    public String insert(User user) {
        return Response.body(userService.insert(user));
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
    public String page(User user) {
        return Response.body(userService.page(user));
    }

    @RequestMapping("/select")
    public String select(User user) {
        return Response.body(userService.page(user));
    }

    @RequestMapping("/get")
    public String get(User user) {
        return Response.body(userService.get(user));
    }


}
