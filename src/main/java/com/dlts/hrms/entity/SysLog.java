package com.dlts.hrms.entity;

import java.util.Date;

public class SysLog {

	private String id;private String type;private String title;private String createUserId;private Date createTime;private String remoteAddr;private String userAgent;private String requestUri;private String method;private String params;private String exception;public String getId(){return this.id;}public void setId(String id){this.id=id;}public String getType(){return this.type;}public void setType(String type){this.type=type;}public String getTitle(){return this.title;}public void setTitle(String title){this.title=title;}public String getCreateUserId(){return this.createUserId;}public void setCreateUserId(String createUserId){this.createUserId=createUserId;}public Date getCreateTime(){return this.createTime;}public void setCreateTime(Date createTime){this.createTime=createTime;}public String getRemoteAddr(){return this.remoteAddr;}public void setRemoteAddr(String remoteAddr){this.remoteAddr=remoteAddr;}public String getUserAgent(){return this.userAgent;}public void setUserAgent(String userAgent){this.userAgent=userAgent;}public String getRequestUri(){return this.requestUri;}public void setRequestUri(String requestUri){this.requestUri=requestUri;}public String getMethod(){return this.method;}public void setMethod(String method){this.method=method;}public String getParams(){return this.params;}public void setParams(String params){this.params=params;}public String getException(){return this.exception;}public void setException(String exception){this.exception=exception;}

}
