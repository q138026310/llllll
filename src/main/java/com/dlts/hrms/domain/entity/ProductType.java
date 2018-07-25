package com.dlts.hrms.domain.entity;

import javax.persistence.Column;
import javax.persistence.Table;

/**
 * 商品分类
 */
@Table(name = "sys_product_type")
public class ProductType extends BaseEntity {

    /**
     * 分类名称
     */
    @Column(length = 10)
    private String name;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
