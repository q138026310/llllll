package com.dlts.hrms.web;

import com.dlts.hrms.domain.cm.Response;
import com.dlts.hrms.domain.entity.User;
import com.dlts.hrms.service.impl.UserService;
import com.dlts.hrms.utils.JsonUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserAction extends BaseAction<User> {

    Logger logger = Logger.getLogger(getClass());

    @Autowired
    UserService userService;

    @RequestMapping("/insert")
    public String insert(User user) {
        return Response.body(userService.insert(user));
    }

    @RequestMapping("/update")
    public String update(User user) {
        return Response.body(userService.updateByExampleSelective(user));
    }

    @RequestMapping("/delete")
    public String delete(User user) {
        return Response.body(userService.delete(user));
    }

    @RequestMapping("/selectAll")
    public String selectAll() {
        return Response.body(userService.selectAll());
    }
}
