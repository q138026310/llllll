package com.dlts.hrms.domain.entity;

import com.dlts.hrms.domain.cm.GlobalConstant;
import com.dlts.hrms.domain.cm.Validate;

import javax.persistence.Table;
import java.util.Date;

@Table(name = "sys_user")
public class User extends BaseEntity {
    @Validate
    private Long companyId;
    private Long departmentId = GlobalConstant.DbDefaultValue.BIGINT;
    @Validate
    private String username;
    @Validate
    private String password;
    @Validate
    private String code = GlobalConstant.DbDefaultValue.CHAR;
    @Validate
    private String name;
    private String email= GlobalConstant.DbDefaultValue.CHAR;
    private String phone= GlobalConstant.DbDefaultValue.CHAR;
    private Long mobile;
    private String photo= GlobalConstant.DbDefaultValue.CHAR;
    private Integer loginIp= GlobalConstant.DbDefaultValue.INT;
    private Date loginTime;
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
    private String remarks;


    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public Long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Long getMobile() {
        return mobile;
    }

    public void setMobile(Long mobile) {
        this.mobile = mobile;
    }


    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }



    public Date getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
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

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public Long getUpdateUserId() {
        return updateUserId;
    }

    public void setUpdateUserId(Long updateUserId) {
        this.updateUserId = updateUserId;
    }


    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}
