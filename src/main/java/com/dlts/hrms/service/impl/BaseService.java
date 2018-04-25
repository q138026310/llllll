package com.dlts.hrms.service.impl;

import com.dlts.hrms.config.LmsMapper;
import com.dlts.hrms.domain.cm.GlobalConstant;
import com.dlts.hrms.domain.cm.PageResult;
import com.dlts.hrms.domain.cm.Unified;
import com.dlts.hrms.domain.entity.BaseEntity;
import com.dlts.hrms.utils.DateUtils;
import com.dlts.hrms.utils.ServiceUtils;
import com.dlts.hrms.utils.UuidUtils;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.apache.commons.beanutils.PropertyUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

/**
 * Created by admin on 2018/4/25.
 */
public class BaseService {

    public Unified<Integer> insert(Object bean, LmsMapper mapper) {
        Unified<Integer> unified = Unified.create(Integer.class);

        try {
            PropertyUtils.setProperty(bean,"id",UuidUtils.getUuid());
            PropertyUtils.setProperty(bean,"status",GlobalConstant.Status.NORMAL);
            PropertyUtils.setProperty(bean,"createTime",DateUtils.format(DateUtils.now()));
            Object loginUserId = PropertyUtils.getProperty(bean,"loginUserId");
            PropertyUtils.setProperty(bean,"createUserId",loginUserId);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

        ServiceUtils.check(bean,GlobalConstant.DbOperatorType.INSERT);
        unified.setData(mapper.insert(bean));
        return unified;
    }

    public Unified<PageResult> page(Object bean,LmsMapper mapper) {
        BaseEntity entity = (BaseEntity) bean;
        Page page = PageHelper.startPage(entity.getPage(),entity.getRows());
        Unified<PageResult> unified = Unified.create(PageResult.class);
        PageResult pageResult = PageResult.create();
        pageResult.setData(mapper.selectByExample(ServiceUtils.getCustomerExample(bean)));
        pageResult.setCount(page.getTotal());
        unified.setData(pageResult);
        return unified;
    }

    public Unified<Integer> update(Object bean,LmsMapper mapper) {
        Unified<Integer> unified = Unified.create(Integer.class);

        try {
            PropertyUtils.setProperty(bean,"updateTime",DateUtils.format(DateUtils.now()));
            Object loginUserId = PropertyUtils.getProperty(bean,"loginUserId");
            PropertyUtils.setProperty(bean,"updateUserId",loginUserId);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

        ServiceUtils.check(bean,GlobalConstant.DbOperatorType.UPDATE);
        unified.setData(mapper.updateByExampleSelective(bean,ServiceUtils.getDefaultExample(bean)));

        return unified;
    }

    public Unified<Object> get(Object bean,LmsMapper mapper) {
        Unified<Object> unified = new Unified<>();
        BaseEntity entity = (BaseEntity) bean;
        if (entity.getId()==null) {
            unified.setResult(GlobalConstant.Result.PARAM_ERROR);
        } else {
            List<Object> data = mapper.selectByExample(ServiceUtils.getDefaultExample(bean));
            if( data.size()==1 ){
                unified.setData(data.get(0));
            }
        }
        return unified;
    }
}
