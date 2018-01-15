package com.dlts.hrms.entity;

import java.util.Date;

public class SysDict {

	private String id;private String value;private String label;private String type;private String description;private Integer sort;private String parentId;private String createBy;private Date createDate;private String updateBy;private Date updateDate;private String remarks;private String delFlag;public String getId(){return this.id;}public void setId(String id){this.id=id;}public String getValue(){return this.value;}public void setValue(String value){this.value=value;}public String getLabel(){return this.label;}public void setLabel(String label){this.label=label;}public String getType(){return this.type;}public void setType(String type){this.type=type;}public String getDescription(){return this.description;}public void setDescription(String description){this.description=description;}public Integer getSort(){return this.sort;}public void setSort(Integer sort){this.sort=sort;}public String getParentId(){return this.parentId;}public void setParentId(String parentId){this.parentId=parentId;}public String getCreateBy(){return this.createBy;}public void setCreateBy(String createBy){this.createBy=createBy;}public Date getCreateDate(){return this.createDate;}public void setCreateDate(Date createDate){this.createDate=createDate;}public String getUpdateBy(){return this.updateBy;}public void setUpdateBy(String updateBy){this.updateBy=updateBy;}public Date getUpdateDate(){return this.updateDate;}public void setUpdateDate(Date updateDate){this.updateDate=updateDate;}public String getRemarks(){return this.remarks;}public void setRemarks(String remarks){this.remarks=remarks;}public String getDelFlag(){return this.delFlag;}public void setDelFlag(String delFlag){this.delFlag=delFlag;}

}
