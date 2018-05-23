package com.dlts.hrms.domain.entity;

import com.dlts.hrms.domain.cm.Validate;

import javax.persistence.Column;
import javax.persistence.Table;

@Table(name = "sys_user_role")
public class UserRole extends BaseEntity{

    @Validate
    @Column(length = 19)
    private Long userId;

    @Validate
    @Column(length = 19)
    private Long roleId;

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

}
