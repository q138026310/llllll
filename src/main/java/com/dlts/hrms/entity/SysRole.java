package com.dlts.hrms.entity;

import java.util.Date;

public class SysRole {

	private String id;private String companyId;private String departmentId;private String name;private String createUserId;private Date createTime;private String updateUserId;private Date updateTime;private String remarks;public String getId(){return this.id;}public void setId(String id){this.id=id;}public String getCompanyId(){return this.companyId;}public void setCompanyId(String companyId){this.companyId=companyId;}public String getDepartmentId(){return this.departmentId;}public void setDepartmentId(String departmentId){this.departmentId=departmentId;}public String getName(){return this.name;}public void setName(String name){this.name=name;}public String getCreateUserId(){return this.createUserId;}public void setCreateUserId(String createUserId){this.createUserId=createUserId;}public Date getCreateTime(){return this.createTime;}public void setCreateTime(Date createTime){this.createTime=createTime;}public String getUpdateUserId(){return this.updateUserId;}public void setUpdateUserId(String updateUserId){this.updateUserId=updateUserId;}public Date getUpdateTime(){return this.updateTime;}public void setUpdateTime(Date updateTime){this.updateTime=updateTime;}public String getRemarks(){return this.remarks;}public void setRemarks(String remarks){this.remarks=remarks;}

}
