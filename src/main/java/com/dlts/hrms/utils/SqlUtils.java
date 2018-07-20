package com.dlts.hrms.utils;

import com.dlts.hrms.domain.cm.App;

/**
 * Created by admin on 2018/7/20.
 */
public class SqlUtils {
    private SqlUtils(){}

    public static String order(String column,String direction){
        return StringUtils.concat(App.Symbol.SPACE,column, App.Symbol.SPACE,direction);
    }
}
