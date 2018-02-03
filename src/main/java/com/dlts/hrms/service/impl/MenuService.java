package com.dlts.hrms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dlts.hrms.cm.Gap;
import com.dlts.hrms.entity.SysMenu;
import com.dlts.hrms.mapper.SysMenuMapper;
import com.dlts.hrms.service.IMenuService;

@Service("menuService")
public class MenuService implements IMenuService {

    @Autowired
    SysMenuMapper sysMenuMapper;

    @Override
    public List<SysMenu> findUserMenu(String userId) {
        Gap map = Gap.newMap("userId", userId);
        return sysMenuMapper.findUserMenu(map.map());
    }

}
