package com.dlts.hrms.entity;

import java.util.Date;

public class SysDepartment {

	private String id;private String companyId;private String parentId;private String name;private String master;private String phone;private String fax;private String email;private String createBy;private Date createDate;private String updateBy;private Date updateDate;private String remarks;public String getId(){return this.id;}public void setId(String id){this.id=id;}public String getCompanyId(){return this.companyId;}public void setCompanyId(String companyId){this.companyId=companyId;}public String getParentId(){return this.parentId;}public void setParentId(String parentId){this.parentId=parentId;}public String getName(){return this.name;}public void setName(String name){this.name=name;}public String getMaster(){return this.master;}public void setMaster(String master){this.master=master;}public String getPhone(){return this.phone;}public void setPhone(String phone){this.phone=phone;}public String getFax(){return this.fax;}public void setFax(String fax){this.fax=fax;}public String getEmail(){return this.email;}public void setEmail(String email){this.email=email;}public String getCreateBy(){return this.createBy;}public void setCreateBy(String createBy){this.createBy=createBy;}public Date getCreateDate(){return this.createDate;}public void setCreateDate(Date createDate){this.createDate=createDate;}public String getUpdateBy(){return this.updateBy;}public void setUpdateBy(String updateBy){this.updateBy=updateBy;}public Date getUpdateDate(){return this.updateDate;}public void setUpdateDate(Date updateDate){this.updateDate=updateDate;}public String getRemarks(){return this.remarks;}public void setRemarks(String remarks){this.remarks=remarks;}

}
