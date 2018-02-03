package com.dlts.hrms.cm;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import com.dlts.hrms.utils.JsonUtils;

public class Response {

    public static String body(Object obj) {

        Result result = Result.newResult();
        result.setData(obj);

        String json = JsonUtils.toJson(result);
        return encode(json);
    }

    public static String encode(String value) {
        try {
            return URLEncoder.encode(value, GlobalConstant.Encode.UTF_8);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }

}
