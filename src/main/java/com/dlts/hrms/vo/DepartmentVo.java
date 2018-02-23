package com.dlts.hrms.vo;

import com.dlts.hrms.entity.SysDepartment;

public class DepartmentVo extends SysDepartment {

    private int start;
    private int limit;

    private String loginCompanyId;

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

    public String getLoginCompanyId() {
        return loginCompanyId;
    }

    public void setLoginCompanyId(String loginCompanyId) {
        this.loginCompanyId = loginCompanyId;
    }

}
