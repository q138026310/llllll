package com.dlts.hrms.mapper;

import java.util.List;
import java.util.Map;

import com.dlts.hrms.entity.SysMenu;

public interface SysMenuMapper extends Mapper<SysMenu> {
    public List<SysMenu> findUserMenu(Map<String, Object> map);
}
