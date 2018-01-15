package com.dlts.hrms.cm;

/**
 * @Description: 全局静态常量
 */
public class GlobalConstant {

    public enum Common {
        PARAM_ERROR(100000, "参数错误"), NAME_EXISTS(100001, "名称重复");

        public int value;
        public String text;

        private Common(int value, String text) {
            this.value = value;
            this.text = text;
        }

        @Override
        public String toString() {
            return this.value + "," + this.text;
        }
    }

    public enum User {
        NAME_REPEAT(101000, "用户名称重复"), ADMIN_DELETE_NO(101001, "超管不能删除");
        public int value;
        public String text;

        private User(int value, String text) {
            this.value = value;
            this.text = text;
        }

        @Override
        public String toString() {
            return this.value + "," + this.text;
        }
    }

    public enum Login {
        USER_NOT_EXISTS(102000, "用户不存在"), PASSWORD_WRONG(102001, "密码错误");

        public int value;
        public String text;

        private Login(int value, String text) {
            this.value = value;
            this.text = text;
        }

        @Override
        public String toString() {
            return this.value + "," + this.text;
        }
    }



}

