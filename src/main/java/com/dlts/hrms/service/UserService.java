package com.dlts.hrms.service;

import com.dlts.hrms.cm.ServiceBean;
import com.dlts.hrms.entity.SysUser;

public interface UserService {

	public ServiceBean login(SysUser user);

}
