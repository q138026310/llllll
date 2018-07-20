package com.dlts.hrms.domain.cm;

import com.dlts.hrms.utils.JsonUtils;

public class Response {

    public static String body(Object obj) {
        String json = JsonUtils.toJson(obj);
        return json;
    }

    // public static String encode(String value) {
    // try {
    // return URLEncoder.encode(value, App.Encode.UTF_8);
    // } catch (UnsupportedEncodingException e) {
    // e.printStackTrace();
    // }
    // return null;
    // }

}
