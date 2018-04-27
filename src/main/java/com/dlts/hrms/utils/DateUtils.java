package com.dlts.hrms.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by admin on 2018/4/16.
 */
public class DateUtils {

    private static String PATTERN = "yyyy-MM-dd HH:mm:ss";

    private static String PATTERN_NUMBER = "yyyy-MM-dd HH:mm:ss";

    private static SimpleDateFormat SDF = new SimpleDateFormat(PATTERN);

    private static SimpleDateFormat SDF_NUMBER = new SimpleDateFormat(PATTERN_NUMBER);

    public static Date now(){
        return new Date();
    }

    public static String format(Date date){
        return SDF.format(date);
    }

    public static String formatNumber(Date date){
        return SDF_NUMBER.format(date);
    }

}
