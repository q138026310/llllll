<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%
 
    String apage = request.getParameter("page");
	int pagei = Integer.parseInt(apage);
	int end = pagei*10;
	if(end>102)end = 102;

    out.print("{");
	out.print("\"total\":102,");
	out.print("\"rows\":[");
	
	int index = 0;
	for( int i=(pagei-1)*10+1 ; i<=end ; i++ ){
		if(index==0){
			out.print("{\"id\":"+i+",\"name\":\"张三"+i+"\",\"sex\":0,\"state\":0,\"phone\":\"1346589741"+i+"\",\"yyy\":\"大大幅度"+i+"\"}");
		}else{
			out.print(",{\"id\":"+i+",\"name\":\"张三"+i+"\",\"sex\":0,\"state\":0,\"phone\":\"1346589741"+i+"\",\"yyy\":\"大大幅度"+i+"\"}");
		}
		
		index++;
	}
	
	out.print("]");
	out.print("}");
%>