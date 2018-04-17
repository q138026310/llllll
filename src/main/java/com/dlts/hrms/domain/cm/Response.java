package com.dlts.hrms.domain.cm;

import com.dlts.hrms.utils.JsonUtils;

public class Response {

    public static <T> String body(Unified<T> u) {
        String json = JsonUtils.toJson(u);
        return json;
    }

    // public static String encode(String value) {
    // try {
    // return URLEncoder.encode(value, GlobalConstant.Encode.UTF_8);
    // } catch (UnsupportedEncodingException e) {
    // e.printStackTrace();
    // }
    // return null;
    // }

}
