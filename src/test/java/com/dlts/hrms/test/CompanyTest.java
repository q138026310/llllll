package com.dlts.hrms.test;

import com.google.common.collect.Maps;
import org.junit.Test;

import java.util.Map;

/**
 * Created by admin on 2018/4/25.
 */
public class CompanyTest {

    @Test
    public void test_page() {
        String url = App.URL+"/company/insert";
        Map<String,String> params = Maps.newHashMap();
        App.test(url,params);
    }

}
