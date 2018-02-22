package com.dlts.hrms.cm;

public class GlobalConstant {


    public static Gnum LOGIN_USERNAME_NULL = Gnum.newGnum(100000, "用户名为空");
    public static Gnum LOGIN_PASSWORD_NULL = Gnum.newGnum(100001, "密码为空");
    public static Gnum LOGIN_PASSWORD_ERROR = Gnum.newGnum(100002, "密码错误");
    public static Gnum LOGIN_USERNAME_ERROR = Gnum.newGnum(100003, "用户名不存在");

    public static Gnum COMPANY_NAME_EXISTS = Gnum.newGnum(100005, "公司名称重复");
    public static Gnum COMPANY_CODE_EXISTS = Gnum.newGnum(100006, "公司编号重复");

    public static Gnum ACCESS_DENIED = Gnum.newGnum(200001, "access denied");
    public static Gnum PARAM_ERROR = Gnum.newGnum(200002, "access denied");

    public static int SUCCESS = 0;
    public static String COMPANY_ROOT_CODE = "10";

    public static class Encode {
        public static String UTF_8 = "UTF-8";
    }

}
