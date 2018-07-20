package com.dlts.hrms.service.base;

import com.dlts.hrms.config.LmsMapper;
import com.dlts.hrms.domain.cm.App;
import com.dlts.hrms.domain.cm.PageResult;
import com.dlts.hrms.domain.cm.Unified;
import com.dlts.hrms.domain.entity.BaseEntity;
import com.dlts.hrms.domain.ex.ServiceException;
import com.dlts.hrms.utils.*;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.apache.commons.beanutils.PropertyUtils;
import tk.mybatis.mapper.entity.Example;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

/**
 * Created by admin on 2018/4/25.
 */
public class BaseService {

    protected Unified<Integer> insert(Object bean, LmsMapper mapper) {
        Unified<Integer> unified = Unified.create(Integer.class);
        setInsertBean(bean);
        unified.setData(mapper.insert(bean));
        return unified;
    }

    protected <T> Unified<Integer> insertBatch(List<T> beans, LmsMapper mapper) {
        Unified<Integer> unified = Unified.create(Integer.class);
        for( T bean : beans ){
            setInsertBean(bean);
        }
        unified.setData(mapper.insertList(beans));
        return unified;
    }

    protected PageResult page(Object bean,LmsMapper mapper) {
        BaseEntity entity = (BaseEntity) bean;
        Page page = PageHelper.startPage(entity.getPage(),entity.getLimit());
        PageResult pageResult = PageResult.create();
        Example example = new Example(bean.getClass());
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo(App.Property.CUSTOMER_ID,entity.getCustomerId());
        criteria.andGreaterThan(App.Property.STATUS,0);
        example.setOrderByClause(SqlUtils.order(App.Property.CREATE_TIME, App.SqlOrder.DESC));
        pageResult.setData(mapper.selectByExample(example));

        pageResult.setCount(page.getTotal());
        return pageResult;
    }

    /**
     * 有值更新 空值不更新
     * @param bean
     * @param mapper
     * @return
     */
    protected Unified<Integer> update(Object bean,LmsMapper mapper) {
        Unified<Integer> unified = Unified.create(Integer.class);

        try {
            PropertyUtils.setProperty(bean, App.Property.UPDATE_TIME,DateUtils.format(DateUtils.now()));
            Object loginUserId = PropertyUtils.getProperty(bean, App.Property.LOGIN_USER_ID);
            PropertyUtils.setProperty(bean, App.Property.UPDATE_USER_ID,loginUserId);
            ServiceUtils.check(bean, App.DbOperatorType.UPDATE);
        } catch (IllegalAccessException e) {
            throw new ServiceException(e);
        } catch (InvocationTargetException e) {
            throw new ServiceException(e);
        } catch (NoSuchMethodException e) {
            throw new ServiceException(e);
        }

        unified.setData(mapper.updateByExampleSelective(bean,ServiceUtils.getDefaultExample(bean)));

        return unified;
    }

    protected <T> Unified<T> get(T bean,LmsMapper mapper) {
        Unified<T> unified = new Unified<T>();
        BaseEntity entity = (BaseEntity) bean;
        if (entity.getId()==null) {
            unified.setResult(App.Result.PARAM_ERROR);
        } else {
            List<T> data = mapper.select(bean);
            if( data.size()==1 ){
                unified.setData(data.get(0));
            }
        }
        return unified;
    }

    protected <T> Unified<List<T>> select(T bean,LmsMapper mapper) {
        Unified<List<T>> unified = new Unified<List<T>>();
        unified.setData(mapper.select(bean));
        return unified;
    }

    private Object getFieldDefaultValue(Field field){
        String name = field.getType().getSimpleName();
        if( name.equals("Long") ){
            return App.DbDefaultValue.BIGINT;
        }else if( name.equals("String") ){
            return App.DbDefaultValue.CHAR;
        }else if( name.equals("Integer") ){
            return App.DbDefaultValue.INT;
        }else{
            return null;
        }
    }

    private void setInsertBean(Object bean){
        try {
            PropertyUtils.setProperty(bean, App.Property.ID,UuidUtils.getUuid());
            PropertyUtils.setProperty(bean, App.Property.STATUS, App.Status.NORMAL);
            PropertyUtils.setProperty(bean, App.Property.CREATE_TIME,DateUtils.format(DateUtils.now()));
            Object loginUserId = PropertyUtils.getProperty(bean, App.Property.LOGIN_USER_ID);
            PropertyUtils.setProperty(bean, App.Property.CREATE_USER_ID,loginUserId);


            ServiceUtils.check(bean, App.DbOperatorType.INSERT);

            //check success after
            Field[] fields = bean.getClass().getDeclaredFields();

            for(Field field : fields){
                Object value = PropertyUtils.getProperty(bean,field.getName());
                if( value == null ){
                    PropertyUtils.setProperty(bean,field.getName(),getFieldDefaultValue(field));
                }
            }
        } catch (IllegalAccessException e) {
            throw new ServiceException(e);
        } catch (InvocationTargetException e) {
            throw new ServiceException(e);
        } catch (NoSuchMethodException e) {
            throw new ServiceException(e);
        }
    }
}
