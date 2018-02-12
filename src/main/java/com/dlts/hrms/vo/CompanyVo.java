package com.dlts.hrms.vo;

import com.dlts.hrms.entity.SysCompany;

public class CompanyVo extends SysCompany {

    private int start;
    private int limit;

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

}
