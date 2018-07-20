package com.dlts.hrms.utils;

/**
 * Created by admin on 2018/7/20.
 */
public class StringUtils {

    private StringUtils(){}

    public static String concat(String...values){
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < values.length; i++) {
            sb.append(values[i]);
        }

        return sb.toString();
    }

}
