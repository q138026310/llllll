/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2014-2016 abel533@gmail.com
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and
 * associated documentation files (the "Software"), to deal in the Software without restriction,
 * including without limitation the rights to use, copy, modify, merge, publish, distribute,
 * sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or
 * substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT
 * NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM,
 * DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package com.dlts.hrms.test;

import com.google.common.collect.Maps;
import org.junit.Test;

import java.util.Map;

public class UserTest {

    @Test
    public void test_trans() {
        String url = App.URL+"/user/trans";
        Map<String,String> params = Maps.newHashMap();
        params.put("customerId","1523438106394466426");
        params.put("code","789564");
        params.put("name","iujolk");
        params.put("companyId","1523438106394466421");
        params.put("username","123");
        params.put("password","234");
        App.test(url,params);
    }

    @Test
    public void test_page() {
        String url = App.URL+"/user/page";
        Map<String,String> params = Maps.newHashMap();
        App.test(url,params);
    }

    @Test
    public void test_insert() {
        String url = App.URL+"/user/insert";
        Map<String,String> params = Maps.newHashMap();
        params.put("customerId","1523438106394466426");
        params.put("code","00110");
        params.put("name","zhangsan");
        params.put("companyId","1523438106394466421");
        params.put("username","sdfsd");
        params.put("password","sdfasdfd");
        App.test(url,params);
    }

    @Test
    public void test_update() {
        String url = App.URL+"/user/update";
        Map<String,String> params = Maps.newHashMap();
        params.put("id","1523438854182887211");
        params.put("email","2@qq.com");
        App.test(url,params);
    }




}
