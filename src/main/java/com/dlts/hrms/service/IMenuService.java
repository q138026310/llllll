package com.dlts.hrms.service;

import java.util.List;

import com.dlts.hrms.entity.SysMenu;

public interface IMenuService {

    /**
     * 查询用户的菜单
     * 
     * @param userId
     * @return
     */
    public List<SysMenu> findUserMenu(String userId);

}
