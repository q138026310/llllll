package com.dlts.hrms.service.impl;

import com.dlts.hrms.domain.cm.GlobalConstant;
import com.dlts.hrms.utils.DateUtils;
import com.dlts.hrms.utils.ServiceUtils;
import com.dlts.hrms.utils.UuidUtils;
import com.github.pagehelper.PageHelper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dlts.hrms.domain.cm.Unified;
import com.dlts.hrms.domain.entity.User;
import com.dlts.hrms.domain.po.login.LoginPo;
import com.dlts.hrms.domain.vo.login.LoginVo;
import com.dlts.hrms.mapper.UserMapper;
import com.dlts.hrms.utils.Md5Utils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserMapper userMapper;

    public Unified<LoginPo> login(LoginVo loginVo) {

        Unified<LoginPo> unified = Unified.create(LoginPo.class);

        User user = new User();
        user.setUsername(loginVo.getUsername());
        user = userMapper.selectOne(user);

        if (user != null && user.getPassword().equals(loginVo.getPassword())) {

            user.setPassword(null);
            loginVo.setPassword(null);

            LoginPo loginPo = new LoginPo();
            loginPo.setUser(user);
            loginPo.setToken(Md5Utils.encrypt(user.getCustomerId()));
            unified.setData(loginPo);
        } else {
            unified.setResult(1);
        }

        return unified;
    }

    public Unified<Integer> insert(User user) {
        Unified<Integer> unified = Unified.create(Integer.class);
        user.setId(UuidUtils.getUuid());
        user.setStatus(GlobalConstant.Status.NORMAL);
        user.setCreateUserId(user.getLoginUserId());
        user.setCreateTime(DateUtils.now());

        ServiceUtils.check(user,GlobalConstant.DbOperatorType.INSERT);
        unified.setData(userMapper.insert(user));
        return unified;
    }

    public Unified<Integer> delete(User user) {
        user.setStatus(GlobalConstant.Status.DELETE);
        return updateByExampleSelective(user);
    }

    public Unified<List<User>> selectAll() {
        Unified<List<User>> unified = new Unified<List<User>>();
        unified.setData(userMapper.getActivityAll(null));
        //userMapper.selectByRowBounds()
PageHelper.startPage(1,1);


        return unified;

    }

    public Unified<User> selectByPrimaryKey(String id) {
        Unified<User> unified = new Unified<User>();
        if (StringUtils.isBlank(id)) {
            unified.setResult(GlobalConstant.Result.PARAM_ERROR);
        } else {
            unified.setData(userMapper.selectByPrimaryKey(id));
        }

        return unified;
    }

    public Unified<Integer> updateByExampleSelective(User user) {
        Unified<Integer> unified = Unified.create(Integer.class);
        user.setUpdateUserId(user.getLoginUserId());
        user.setUpdateTime(DateUtils.now());

        ServiceUtils.check(user,GlobalConstant.DbOperatorType.UPDATE);
        unified.setData(userMapper.updateByPrimaryKeySelective(user));

        userMapper.updateByExampleSelective(user,ServiceUtils.getDefaultExample(user));
        return unified;
    }

}
