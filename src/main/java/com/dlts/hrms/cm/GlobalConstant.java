package com.dlts.hrms.cm;

public class GlobalConstant {

	public static int SUCCESS = 0;

	public static Gnum LOGIN_USERNAME_NULL = Gnum.newGnum(100000, "用户名为空");
	public static Gnum LOGIN_PASSWORD_NULL = Gnum.newGnum(100001, "密码为空");
	public static Gnum LOGIN_PASSWORD_ERROR = Gnum.newGnum(100002, "密码错误");
	public static Gnum LOGIN_USERNAME_ERROR = Gnum.newGnum(100003, "用户名不存在");

}
