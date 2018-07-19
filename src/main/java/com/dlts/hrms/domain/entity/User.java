package com.dlts.hrms.domain.entity;

import com.dlts.hrms.domain.cm.Validate;

import javax.persistence.Column;
import javax.persistence.Table;
import java.io.Serializable;

@Table(name = "sys_user")
public class User extends BaseEntity implements Serializable {

    /**
     * 公司id
     *
     * 当前不考虑多公司
     *
     * 后续考虑多公司的话 用户添加界面加上即可
     */
    @Validate
    @Column(length = 19)
    private Long companyId;

    @Column(length = 19)
    private Long organizationId;

    @Validate
    @Column(length = 20)
    private String username;

    @Validate
    @Column(length = 100)
    private String password;

    @Validate
    @Column(length = 20)
    private String code;

    @Validate
    @Column(length = 5)
    private String name;

    @Column(length = 30)
    private String email;

    @Column(length = 15)
    private String phone;

    @Column(length = 11)
    private Long mobile;

    @Column(length = 100)
    private String photo;

    @Column(length = 10)
    private Integer loginIp;

    @Column(length = 19)
    private String loginTime;

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

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public Long getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(Long organizationId) {
        this.organizationId = organizationId;
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


    public String getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(String loginTime) {
        this.loginTime = loginTime;
    }

    public Integer getLoginIp() {
        return loginIp;
    }

    public void setLoginIp(Integer loginIp) {
        this.loginIp = loginIp;
    }
}
