package com.dlts.hrms.domain.entity;

import com.dlts.hrms.domain.cm.Validate;

import javax.persistence.Column;
import javax.persistence.Table;

/**
 * 平台注册客户  最最基础数据
 */
@Table(name = "sys_customer")
public class Customer extends BaseEntity{

    @Column(length = 5)
    private String contact;

    @Column(length = 20)
    private String contactPhone;

    @Validate
    private Integer status;

    @Validate
    private Long createUserId;

    @Validate
    private String createTime;

    @Validate(insert=false,update=true)
    private Long updateUserId;

    @Validate(insert=false,update=true)
    private String updateTime;

}
