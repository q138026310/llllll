package com.dlts.hrms.entity;

import java.util.Date;

public class SysMenu {

	private String id;private String parentId;private String name;private Integer sort;private String href;private String icon;public String getId(){return this.id;}public void setId(String id){this.id=id;}public String getParentId(){return this.parentId;}public void setParentId(String parentId){this.parentId=parentId;}public String getName(){return this.name;}public void setName(String name){this.name=name;}public Integer getSort(){return this.sort;}public void setSort(Integer sort){this.sort=sort;}public String getHref(){return this.href;}public void setHref(String href){this.href=href;}public String getIcon(){return this.icon;}public void setIcon(String icon){this.icon=icon;}

}
