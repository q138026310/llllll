package com.dlts.hrms.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dlts.hrms.cm.GlobalConstant;
import com.dlts.hrms.cm.LoginResult;
import com.dlts.hrms.entity.SysUser;
import com.dlts.hrms.mapper.SysCompanyMapper;
import com.dlts.hrms.mapper.SysUserMapper;
import com.dlts.hrms.service.IUserService;
import com.dlts.hrms.service.base.BaseService;
import com.dlts.hrms.utils.StringUtils;

@Service("userService")
public class UserService extends BaseService implements IUserService {

    @Autowired
    SysUserMapper sysUserMapper;

    @Autowired
    SysCompanyMapper sysCompanyMapper;

    @Override
    public LoginResult login(SysUser user) {

        LoginResult bean = LoginResult.newResult();

        if (StringUtils.isEmpty(user.getUsername())) {
            bean.setResult(GlobalConstant.LOGIN_USERNAME_NULL.value);
        }

        if (StringUtils.isEmpty(user.getPassword())) {
            bean.setResult(GlobalConstant.LOGIN_PASSWORD_NULL.value);
        }

        if (bean.isSuccess()) {

            SysUser queryUser = new SysUser();
            queryUser.setUsername(user.getUsername());
            SysUser dbUser = sysUserMapper.get(queryUser);

            if (dbUser == null) {
                bean.setResult(GlobalConstant.LOGIN_USERNAME_ERROR.value);
            } else {
                if (StringUtils.equals(dbUser.getPassword(), user.getPassword())) {
                    dbUser.setPassword(null);
                    bean.setUser(dbUser);
                    bean.setCompany(sysCompanyMapper.getById(dbUser.getCompanyId()));
                } else {
                    bean.setResult(GlobalConstant.LOGIN_PASSWORD_ERROR.value);
                }
            }

        }

        return bean;
    }

}
