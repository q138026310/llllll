package com.dlts.hrms.service.base;

import com.dlts.hrms.config.LmsMapper;
import com.dlts.hrms.domain.cm.GlobalConstant;
import com.dlts.hrms.domain.cm.PageResult;
import com.dlts.hrms.domain.cm.Unified;
import com.dlts.hrms.domain.entity.BaseEntity;
import com.dlts.hrms.domain.entity.Company;
import com.dlts.hrms.domain.ex.ServiceException;
import com.dlts.hrms.utils.DateUtils;
import com.dlts.hrms.utils.ServiceUtils;
import com.dlts.hrms.utils.UuidUtils;
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
        criteria.andEqualTo("customerId",entity.getCustomerId());
        criteria.andGreaterThan("status",0);
        example.setOrderByClause(" create_time desc ");
        pageResult.setData(mapper.selectByExample(example));

        pageResult.setCount(page.getTotal());
        return pageResult;
    }

    protected Unified<Integer> update(Object bean,LmsMapper mapper) {
        Unified<Integer> unified = Unified.create(Integer.class);

        try {
            PropertyUtils.setProperty(bean,"updateTime",DateUtils.format(DateUtils.now()));
            Object loginUserId = PropertyUtils.getProperty(bean,"loginUserId");
            PropertyUtils.setProperty(bean,"updateUserId",loginUserId);
            ServiceUtils.check(bean,GlobalConstant.DbOperatorType.UPDATE);
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
            unified.setResult(GlobalConstant.Result.PARAM_ERROR);
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
            return GlobalConstant.DbDefaultValue.BIGINT;
        }else if( name.equals("String") ){
            return GlobalConstant.DbDefaultValue.CHAR;
        }else if( name.equals("Integer") ){
            return GlobalConstant.DbDefaultValue.INT;
        }else{
            return null;
        }
    }

    private void setInsertBean(Object bean){
        try {
            PropertyUtils.setProperty(bean,"id",UuidUtils.getUuid());
            PropertyUtils.setProperty(bean,"status",GlobalConstant.Status.NORMAL);
            PropertyUtils.setProperty(bean,"createTime",DateUtils.format(DateUtils.now()));
            Object loginUserId = PropertyUtils.getProperty(bean,"loginUserId");
            PropertyUtils.setProperty(bean,"createUserId",loginUserId);


            ServiceUtils.check(bean,GlobalConstant.DbOperatorType.INSERT);

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
