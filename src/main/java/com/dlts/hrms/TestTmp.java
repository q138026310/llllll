package com.dlts.hrms;

import com.dlts.hrms.utils.IpUtils;
import com.dlts.hrms.utils.Md5Utils;

/**
 * Created by admin on 2018/4/25.
 */
public class TestTmp {

    public static void main(String[] args){
        System.out.print(Md5Utils.encrypt("admin"));
    }
}