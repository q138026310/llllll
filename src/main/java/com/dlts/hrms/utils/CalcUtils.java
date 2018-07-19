package com.dlts.hrms.utils;

import com.dlts.hrms.domain.cm.GlobalConstant;

import java.math.BigDecimal;

/**
 * 精确的加减乘除等处理
 */
public class CalcUtils {

    private CalcUtils(){}

    private static final int DEF_DIV_SCALE = 6;

    /**
     * num1 + num2
     * @param num1
     * @param num2
     * @return
     */
    public static double add(double num1,double num2){
        BigDecimal data1 =  BigDecimal.valueOf(num1);
        BigDecimal data2 =  BigDecimal.valueOf(num2);
        return data1.add(data2).doubleValue();
    }

    /**
     * num1 - num2
     * @param num1
     * @param num2
     * @return
     */
    public static double sub(double num1,double num2){
        BigDecimal data1 =  BigDecimal.valueOf(num1);
        BigDecimal data2 =  BigDecimal.valueOf(num2);
        return data1.subtract(data2).doubleValue();
    }

    /**
     * num1 * num2
     * @param num1
     * @param num2
     * @return
     */
    public static double mul(double num1,double num2){
        BigDecimal data1 =  BigDecimal.valueOf(num1);
        BigDecimal data2 =  BigDecimal.valueOf(num2);
        return data1.multiply(data2).doubleValue();
    }

    /**
     * num1 ÷ num2 默认6位小数
     * @param num1
     * @param num2
     * @return
     */
    public static double div(double num1,double num2){
        return div(num1,num2,CalcUtils.DEF_DIV_SCALE);
    }

    /**
     * num1 ÷ num2 scale位小数
     * @param num1
     * @param num2
     * @return
     */
    public static double div(double num1,double num2,int scale){
        if(scale<0){
            throw new IllegalArgumentException("The scale must be a positive integer or zero");
        }
        BigDecimal data1 =  BigDecimal.valueOf(num1);
        BigDecimal data2 =  BigDecimal.valueOf(num2);
        return data1.divide(data2,scale,BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    /**
     * 四舍五入
     * @param num
     * @param scale
     * @return
     */
    public static double round(double num,int scale){
        if(scale<0){
            throw new IllegalArgumentException("The scale must be a positive integer or zero");
        }
        BigDecimal data = BigDecimal.valueOf(num);
        BigDecimal one = new BigDecimal(GlobalConstant.Number.num1);
        return data.divide(one,scale,BigDecimal.ROUND_HALF_UP).doubleValue();
    }

}
