package com.dlts.hrms.web;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dlts.hrms.cm.Response;
import com.dlts.hrms.entity.SysMenu;
import com.dlts.hrms.service.IMenuService;
import com.dlts.hrms.web.base.BaseController;

@Controller
@RequestMapping("menu")
public class MenuController extends BaseController {

    @Resource(name = "menuService")
    IMenuService menuService;

    @ResponseBody
    @RequestMapping("findUserMenu")
    public String findUserMenu() {
        List<SysMenu> menus = menuService.findUserMenu(this.getUserId());
        return Response.body(menus);
    }
}
