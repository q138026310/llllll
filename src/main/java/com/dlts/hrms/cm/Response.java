package com.dlts.hrms.cm;

import com.dlts.hrms.utils.JsonUtils;

public class Response {

	public static String body(Object obj) {
		return JsonUtils.toJson(obj);
	}

}
