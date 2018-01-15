package com.dlts.hrms.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dlts.hrms.entity.SysUser;
import com.dlts.hrms.mapper.SysUserMapper;
import com.dlts.hrms.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    SysUserMapper sysUserMapper;

    @Override
    public SysUser login(SysUser user) {
        SysUser sysUser = sysUserMapper.get(user);

        return sysUser;
    }

}
