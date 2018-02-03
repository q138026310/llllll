package com.dlts.hrms.web.base;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

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

    public SysUser getSysUser() {
        Object objUser = request.getSession().getAttribute("user");
        if (objUser == null) {
            return null;
        } else {
            return (SysUser) objUser;
        }
    }

}
