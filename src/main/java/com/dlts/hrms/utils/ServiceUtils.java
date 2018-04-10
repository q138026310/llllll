package com.dlts.hrms.utils;

import com.dlts.hrms.domain.cm.GlobalConstant;
import com.dlts.hrms.domain.cm.Validate;
import com.dlts.hrms.domain.ex.ServiceException;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.reflect.FieldUtils;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

/**
 * Created by admin on 2018/4/10.
 */
public class ServiceUtils {

    public static void check(Object bean,int dbOperatorType){
        List<Field> fields = FieldUtils.getFieldsListWithAnnotation(bean.getClass(), Validate.class);
        try{
            checkCustomerId(bean);

            for( Field field : fields ){
                checkField(bean,field,dbOperatorType);
            }
        }catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

    }

    private static void checkField(Object bean,Field field,int dbOperatorType) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Validate validate = field.getAnnotation(Validate.class);
        Object obj = PropertyUtils.getProperty(bean,field.getName());
        boolean flag =  (obj==null || StringUtils.isBlank(obj.toString()));

        if( flag && dbOperatorType == GlobalConstant.DbOperatorType.INSERT && validate.insert()){
            throw new ServiceException("param ["+field.getName()+"] error");
        }else if( flag && dbOperatorType == GlobalConstant.DbOperatorType.UPDATE && validate.update() ){
            throw new ServiceException("param ["+field.getName()+"] error");
        }
    }

    private static void checkCustomerId(Object bean) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Object obj = PropertyUtils.getProperty(bean,"customerId");
        if( obj == null || StringUtils.isBlank(obj.toString())){
            throw new ServiceException("param customerId error");
        }
    }


}
