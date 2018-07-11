package com.dlts.hrms.domain.vo.company;

import com.dlts.hrms.domain.entity.BaseEntity;

public class CompanyPageVo extends BaseEntity {

    private String name;
    private String contact;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }
}
