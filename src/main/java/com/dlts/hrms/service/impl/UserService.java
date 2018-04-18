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
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.apache.commons.beanutils.PropertyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;

@Service
public class UserService{

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
        user.setCreateTime(DateUtils.now());
        user.setCreateUserId(user.getLoginUserId());

        ServiceUtils.check(user,GlobalConstant.DbOperatorType.INSERT);
        unified.setData(userMapper.insert(user));
        return unified;
    }

    public Unified<Integer> delete(User user) {
        user.setStatus(GlobalConstant.Status.DELETE);
        return update(user);
    }

    public Unified<PageResult> page(User user) {
        Page page = PageHelper.startPage(user.getPage(),user.getRows());
        Unified<PageResult> unified = Unified.create(PageResult.class);
        PageResult pageResult = PageResult.create();
        pageResult.setData(userMapper.selectByExample(ServiceUtils.getCustomerExample(user)));
        pageResult.setCount(page.getTotal());
        unified.setData(pageResult);
        return unified;
    }

    public Unified<User> get(User user) {
        Unified<User> unified = new Unified<User>();
        if (user.getId()==null) {
            unified.setResult(GlobalConstant.Result.PARAM_ERROR);
        } else {
            userMapper.selectByExample(ServiceUtils.getDefaultExample(user));

            unified.setData(userMapper.selectByPrimaryKey(""));
        }

        return unified;
    }

    public Unified<Integer> update(User user) {
        Unified<Integer> unified = Unified.create(Integer.class);
        user.setUpdateUserId(user.getLoginUserId());
        user.setUpdateTime(DateUtils.now());

        ServiceUtils.check(user,GlobalConstant.DbOperatorType.UPDATE);
        unified.setData(userMapper.updateByPrimaryKeySelective(user));

        userMapper.updateByExampleSelective(user,ServiceUtils.getDefaultExample(user));
        return unified;
    }

}
