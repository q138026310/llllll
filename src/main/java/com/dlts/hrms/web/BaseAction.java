package com.dlts.hrms.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class BaseAction{

    @ExceptionHandler(Exception.class)
    public void processMethod(Exception e, HttpServletRequest request , HttpServletResponse response) throws IOException {
        e.printStackTrace();
    }

}
