package com.dlts.hrms.domain.entity;

import com.dlts.hrms.domain.cm.Validate;

import javax.persistence.Column;
import javax.persistence.Table;

@Table(name="t_purchase_order")
public class PurchaseOrder extends BaseEntity{

    @Validate
    @Column(length = 20,unique=true)
    private String code;

    @Column(length = 100)
    private String remarks;

    @Validate
    @Column(length = 1)
    private Integer type;

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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Long getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(Long createUserId) {
        this.createUserId = createUserId;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public Long getUpdateUserId() {
        return updateUserId;
    }

    public void setUpdateUserId(Long updateUserId) {
        this.updateUserId = updateUserId;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }
}
