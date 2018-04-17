package com.dlts.hrms.utils;

import com.dlts.hrms.domain.cm.GlobalConstant;
import com.dlts.hrms.domain.cm.Validate;
import com.dlts.hrms.domain.entity.BaseEntity;
import com.dlts.hrms.domain.entity.User;
import com.dlts.hrms.domain.ex.ServiceException;
import com.sun.xml.internal.rngom.parse.host.Base;
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

    public static Example getDefaultExample(Object bean){
        Example example=new Example(bean.getClass());
        Example.Criteria criteria = example.createCriteria();
        BaseEntity entity = (BaseEntity) bean;
        criteria.andEqualTo("customerId",entity.getCustomerId());
        criteria.andEqualTo("id",entity.getId());
        return example;
    }


    public static void check(Object bean,int dbOperatorType){
        try{
            switch (dbOperatorType){
                case GlobalConstant.DbOperatorType.INSERT :
                    checkInsert(bean,dbOperatorType);
                    break;
                case GlobalConstant.DbOperatorType.DELETE :
                    checkDelete(bean,dbOperatorType);
                    break;
                case GlobalConstant.DbOperatorType.UPDATE :
                    checkUpdate(bean,dbOperatorType);
                    break;
                case GlobalConstant.DbOperatorType.SELECT :
                    checkSelect(bean,dbOperatorType);
                    break;
            }
        }catch (IllegalAccessException e){
            throw new ServiceException(e);
        }catch (NoSuchMethodException e){
            throw new ServiceException(e);
        }catch (InvocationTargetException e){
            throw new ServiceException(e);
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
                if( obj==null || StringUtils.isBlank(obj.toString()) ){
                    throw new ServiceException("param ["+field.getName()+"] is null");
                }
            }
        }
    }

    private static boolean getValidate(Validate validate,int dbOperatorType){
        boolean flag = false;
        switch (dbOperatorType){
            case GlobalConstant.DbOperatorType.INSERT :
                flag = validate.insert();
                break;
            case GlobalConstant.DbOperatorType.DELETE :
                flag = validate.delete();
                break;
            case GlobalConstant.DbOperatorType.UPDATE :
                flag = validate.update();
                break;
            case GlobalConstant.DbOperatorType.SELECT :
                flag = validate.select();
                break;
        }
        return flag;
    }

}
