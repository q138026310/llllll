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
        String url = App.BASE_URL+"/company/insert";
        Map<String,String> params = Maps.newHashMap();
        params.put("name","ooo");
        params.put("parentId","-1");
        App.test(url,params);
    }

    @Test
    public void test_select() {
        String url = App.BASE_URL+"/company/select";
        Map<String,String> params = Maps.newHashMap();
        //params.put("name","111");
        App.test(url,params);
    }

}
