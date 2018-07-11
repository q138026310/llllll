package com.dlts.hrms.web;

import com.dlts.hrms.domain.cm.GlobalConstant;
import com.dlts.hrms.domain.cm.Response;
import com.dlts.hrms.domain.cm.Unified;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class BaseAction{

    @ExceptionHandler(Exception.class)
    public void processMethod(Exception e, HttpServletRequest request , HttpServletResponse response) throws IOException {
        Unified<String> unified = Unified.create(String.class);
        unified.setResult(GlobalConstant.Result.BUSI_ERROR);
        unified.setData(e.getMessage());
        response.getWriter().print(Response.body(unified));
        e.printStackTrace();
    }

}
