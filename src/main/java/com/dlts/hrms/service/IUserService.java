package com.dlts.hrms.service;

import com.dlts.hrms.cm.Result;
import com.dlts.hrms.entity.SysUser;

public interface IUserService {

	public Result login(SysUser user);

}
