package com.dlts.hrms.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by admin on 2018/4/16.
 */
public class DateUtils {

    private static String PATTERN = "yyyy-MM-dd HH:mm:ss";

    private static SimpleDateFormat SDF = new SimpleDateFormat(PATTERN);

    public static Date now(){
        return new Date();
    }

    public static String format(Date date){
        return SDF.format(date);
    }

}
