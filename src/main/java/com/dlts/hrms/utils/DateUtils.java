package com.dlts.hrms.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by admin on 2018/4/16.
 */
public class DateUtils {

    private DateUtils(){}

    private static String PATTERN = "yyyy-MM-dd HH:mm:ss";

    public static Date now(){
        return new Date();
    }

    public static String format(Date date){
        return new SimpleDateFormat(PATTERN).format(date);
    }

}
