package com.dlts.hrms;

import com.dlts.hrms.utils.IpUtils;

/**
 * Created by admin on 2018/4/25.
 */
public class TestTmp {

    public static void main(String[] args){
        System.out.print(IpUtils.ipToInteger("1.1.1.1"));
        System.out.print(IpUtils.IntegerToIp(Integer.MAX_VALUE));
    }
}
