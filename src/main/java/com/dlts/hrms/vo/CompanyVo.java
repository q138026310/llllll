package com.dlts.hrms.vo;

import com.dlts.hrms.entity.SysCompany;

public class CompanyVo extends SysCompany {

    private int start;
    private int limit;

    /**
     * 登陆用户所在的公司逻辑编号
     */
    private String loginCompanyCode;

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public String getLoginCompanyCode() {
        return loginCompanyCode;
    }

    public void setLoginCompanyCode(String loginCompanyCode) {
        this.loginCompanyCode = loginCompanyCode;
    }

}
