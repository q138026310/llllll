package com.dlts.hrms.web.base;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.dlts.hrms.entity.SysCompany;
import com.dlts.hrms.entity.SysUser;

@Controller
public class BaseController {

    @Autowired
    private HttpServletRequest request;

    public HttpServletRequest getRequest() {
        return request;
    }

    public void setRequest(HttpServletRequest request) {
        this.request = request;
    }

    public String getUserId() {
        return getSysUser().getId();
    }

    public String getUsername() {
        return getSysUser().getUsername();
    }

    public SysUser getSysUser() {
        Object objUser = request.getSession().getAttribute("user");
        if (objUser == null) {
            return null;
        } else {
            return (SysUser) objUser;
        }
    }

    public SysCompany getSysCompany() {
        Object obj = request.getSession().getAttribute("company");
        if (obj == null) {
            return null;
        } else {
            return (SysCompany) obj;
        }
    }

    @ExceptionHandler
    public void exceptionHandler(PrintWriter out, Exception ex) {

        if (ex != null) {
            out.print("{\"result\":\"2\",\"message\":\"" + ex.getMessage() + "\"}");
        }
    }

}
