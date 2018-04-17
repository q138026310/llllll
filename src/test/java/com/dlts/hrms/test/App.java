package com.dlts.hrms.test;

import com.dlts.hrms.domain.vo.http.HttpResult;
import com.dlts.hrms.utils.HttpUtils;
import com.dlts.hrms.utils.JsonUtils;
import com.google.common.collect.Maps;
import com.google.gson.JsonObject;
import org.apache.http.Header;

import java.util.Map;

/**
 * Created by admin on 2018/4/10.
 */
public class App {
    public static final String URL = "http://127.0.0.1:8888/hrms";

    public static void test(String url, Map<String,String> params){

        String login_url = URL +"/index/login.spring";

        Map<String,String> loginParams = Maps.newHashMap();

        loginParams.put("username","superadmin");
        loginParams.put("password","superadmin");

        HttpResult result = HttpUtils.get(login_url,loginParams);
        System.out.println("result:   "+result);

        JsonObject login = JsonUtils.toJsonObject(result.getContent());
        String token = login.get("data").getAsJsonObject().get("token").getAsString();

        Map<String,String> headers = Maps.newHashMap();


        String cookieValue = null;
        for(Header header : result.getHeaders()){
            if( header.getName().equals("Set-Cookie") ){
                cookieValue = header.getValue();
                break;
            }
        }
        headers.put("Cookie",cookieValue+";token="+token);

        result = HttpUtils.get(url+".spring",params,headers);
        System.out.println("RESULT::::"+result.getContent());
    }

}
