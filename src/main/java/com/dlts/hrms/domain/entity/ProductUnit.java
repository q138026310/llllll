package com.dlts.hrms.domain.entity;

import javax.persistence.Column;
import javax.persistence.Table;

/**
 * 单位
 */
@Table(name = "sys_product_unit")
public class ProductUnit extends BaseEntity{

    /**
     * 单位名称
     */
    @Column(length = 5)
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
