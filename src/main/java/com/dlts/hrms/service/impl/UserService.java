package com.dlts.hrms.service.impl;

import com.dlts.hrms.domain.cm.GlobalConstant;
import com.dlts.hrms.domain.cm.PageResult;
import com.dlts.hrms.domain.cm.Unified;
import com.dlts.hrms.domain.entity.User;
import com.dlts.hrms.domain.po.login.LoginPo;
import com.dlts.hrms.domain.vo.login.LoginVo;
import com.dlts.hrms.mapper.UserMapper;
import com.dlts.hrms.utils.DateUtils;
import com.dlts.hrms.utils.Md5Utils;
import com.dlts.hrms.utils.ServiceUtils;
import com.dlts.hrms.utils.UuidUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class UserService extends BaseService{

    @Autowired
    UserMapper userMapper;

    public Unified<LoginPo> login(LoginVo loginVo) {
        Unified<LoginPo> unified = Unified.create(LoginPo.class);
        User user = new User();
        user.setUsername(loginVo.getUsername());
        user = userMapper.selectOne(user);

        if (user != null && user.getPassword().equals(Md5Utils.encrypt(loginVo.getPassword()))) {
            user.setPassword(null);
            loginVo.setPassword(null);
            unified.setData(new LoginPo(user,Md5Utils.encrypt(user.getCustomerId())));
        } else {
            unified.setResult(GlobalConstant.Result.BUSI_ERROR);
        }
        return unified;
    }

    public Unified<List<User>> select(User user) {
        Unified<List<User>> unified = new Unified<List<User>>();
        unified.setData(userMapper.selectByExample(ServiceUtils.getCustomerExample(user)));
        return unified;
    }

    public Unified<Integer> insert(User user) {
        user.setPassword(Md5Utils.encrypt(user.getPassword()));
        return insert(user,userMapper);
    }

    public Unified<Integer> delete(User user) {
        user.setStatus(GlobalConstant.Status.DELETE);
        return update(user);
    }

    public Unified<PageResult> page(User user) {
        return page(user,userMapper);
    }

    public Unified<Object> get(User user) {
        return get(user,userMapper);
    }

    public Unified<Integer> update(User user) {
        return update(user,userMapper);
    }

}
