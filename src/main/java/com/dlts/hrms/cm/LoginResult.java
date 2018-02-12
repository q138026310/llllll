package com.dlts.hrms.cm;

import com.dlts.hrms.entity.SysCompany;
import com.dlts.hrms.entity.SysUser;

public class LoginResult {

    private int result = 0;

    private SysUser user;

    private SysCompany company;

    public static LoginResult newResult() {
        LoginResult b = new LoginResult();
        return b;
    }

    public boolean isSuccess() {
        return this.result == GlobalConstant.SUCCESS;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public SysUser getUser() {
        return user;
    }

    public void setUser(SysUser user) {
        this.user = user;
    }

    public SysCompany getCompany() {
        return company;
    }

    public void setCompany(SysCompany company) {
        this.company = company;
    }

}
