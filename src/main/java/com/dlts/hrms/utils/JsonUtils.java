package com.dlts.hrms.utils;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class JsonUtils {

	private static Gson GSON = new Gson();

	public static String toJson(Object obj) {
		return getGson().toJson(obj);
	}

	public static <T> T fromJson(String json, Class<T> t) {
		return getGson().fromJson(json, t);
	}

	public static JsonObject toJsonObject(String json) {
		return getGson().fromJson(json, JsonObject.class);
	}

	private static Gson getGson() {
		return GSON;
	}

}
