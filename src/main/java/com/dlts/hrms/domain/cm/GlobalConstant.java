package com.dlts.hrms.domain.cm;

public final class GlobalConstant {

    public class Encode {
        public final static String UTF_8 = "UTF-8";
    }

    public class encrypt {
        public final static String MD5 = "MD5";
    }

    public class Result {
        public final static int PARAM_ERROR = 1;
        public final static int BUSI_ERROR = 2;
    }

    public static class PostValueType{
        public static final int STRING = 0;
        public static final int FILE = 1;
    }

    public static class Symbol{
        public static final String SEMICOLON = ";";
        public static final String EQUAL = "=";
    }

    public static class DbOperatorType{
        public static final int INSERT = 1;
        public static final int DELETE = 2;
        public static final int UPDATE = 3;
        public static final int SELECT = 4;
    }

    public static class Status{
        public static final int DELETE = 0;
        public static final int NORMAL = 1;
        public static final int DISABLE = 2;
    }

    public static class DbDefaultValue{
        public static final Long  BIGINT= -1l;
        public static final String  CHAR = "-1";
        public static final Integer  INT = -1;
    }

}
