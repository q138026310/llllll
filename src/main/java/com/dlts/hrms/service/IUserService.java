package com.dlts.hrms.service;

import com.dlts.hrms.cm.LoginResult;
import com.dlts.hrms.entity.SysUser;

public interface IUserService {

    public LoginResult login(SysUser user);

}
