package com.dlts.hrms.utils;

import com.dlts.hrms.domain.cm.App;
import com.dlts.hrms.domain.cm.TkQuery;
import com.dlts.hrms.domain.cm.Validate;
import com.dlts.hrms.domain.entity.BaseEntity;
import com.dlts.hrms.domain.ex.ServiceException;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.reflect.FieldUtils;
import tk.mybatis.mapper.entity.Example;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

/**
 * Created by admin on 2018/4/10.
 */
public class ServiceUtils {

    private ServiceUtils(){}

    public static Example getDefaultExample(Object bean){
        Example example=new Example(bean.getClass());
        Example.Criteria criteria = example.createCriteria();
        BaseEntity entity = (BaseEntity) bean;
        criteria.andEqualTo("customerId",entity.getCustomerId());
        criteria.andEqualTo("id",entity.getId());
        return example;
    }

    public static Example getCustomerExample(Object bean){
        Example example=new Example(bean.getClass());
        Example.Criteria criteria = example.createCriteria();
        BaseEntity entity = (BaseEntity) bean;
        criteria.andEqualTo("customerId",entity.getCustomerId());
        return example;
    }

    public static TkQuery getDefaultQuery(Object bean){
        Example example=new Example(bean.getClass());
        Example.Criteria criteria = example.createCriteria();
        BaseEntity entity = (BaseEntity) bean;
        criteria.andEqualTo("customerId",entity.getCustomerId());
        TkQuery query = new TkQuery(example,criteria);
        return query;
    }


    public static void check(Object bean,int dbOperatorType) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {

            switch (dbOperatorType){
                case App.DbOperatorType.INSERT :
                    checkInsert(bean,dbOperatorType);
                    break;
                case App.DbOperatorType.DELETE :
                    checkDelete(bean,dbOperatorType);
                    break;
                case App.DbOperatorType.UPDATE :
                    checkUpdate(bean,dbOperatorType);
                    break;
                case App.DbOperatorType.SELECT :
                    checkSelect(bean,dbOperatorType);
                    break;
            }

    }

    private static void checkInsert(Object bean,int dbOperatorType) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException{
        checkId(bean);
        checkField(bean,dbOperatorType);
    }

    private static void checkDelete(Object bean,int dbOperatorType) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException{
        checkId(bean);
        checkField(bean,dbOperatorType);
    }

    private static void checkUpdate(Object bean,int dbOperatorType) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException{
        checkId(bean);
        checkField(bean,dbOperatorType);
    }

    private static void checkSelect(Object bean,int dbOperatorType){
    }

    private static void checkId(Object bean){
        BaseEntity entity = (BaseEntity) bean;
        if( entity.getId()==null ){
            throw new ServiceException("param id is null");
        }
    }

    private static void checkField(Object bean,int dbOperatorType) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        List<Field> fields = FieldUtils.getFieldsListWithAnnotation(bean.getClass(), Validate.class);
        for( Field field : fields ){
            Validate validate = field.getAnnotation(Validate.class);
            if(getValidate(validate,dbOperatorType)){
                Object obj = PropertyUtils.getProperty(bean,field.getName());
                if( obj==null){
                    throw new ServiceException("param ["+field.getName()+"] is null");
                }
                String value = obj.toString();
                if( StringUtils.isBlank(value)  ){
                    throw new ServiceException("param ["+field.getName()+"] is null");
                }
            }
        }
    }

    private static boolean getValidate(Validate validate,int dbOperatorType){
        boolean flag = false;
        switch (dbOperatorType){
            case App.DbOperatorType.INSERT :
                flag = validate.insert();
                break;
            case App.DbOperatorType.DELETE :
                flag = validate.delete();
                break;
            case App.DbOperatorType.UPDATE :
                flag = validate.update();
                break;
            case App.DbOperatorType.SELECT :
                flag = validate.select();
                break;
        }
        return flag;
    }

}
