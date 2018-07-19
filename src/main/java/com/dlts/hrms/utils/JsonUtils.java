package com.dlts.hrms.utils;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class JsonUtils {

    private JsonUtils(){}

    private static Gson GSON = null;

    public static String toJson(Object obj) {
        return getGson().toJson(obj);
    }

    public static <T> T fromJson(String json, Class<T> t) {
        return getGson().fromJson(json, t);
    }

    public static JsonObject toJsonObject(String json) {
        return getGson().fromJson(json, JsonObject.class);
    }

    public static JsonObject newJsonObject() {
        return new JsonObject();
    }

    private static Gson getGson() {
        if(GSON==null){
            GSON = new Gson();
        }
        return GSON;
    }

}
