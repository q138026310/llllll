package com.dlts.hrms.po;

import com.dlts.hrms.entity.SysCompany;

public class CompanyPo extends SysCompany {

    private String parentName;

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

}
