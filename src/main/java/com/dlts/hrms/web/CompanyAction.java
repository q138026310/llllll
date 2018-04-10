package com.dlts.hrms.web;

import com.dlts.hrms.domain.cm.Response;
import com.dlts.hrms.domain.entity.Company;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/company")
public class CompanyAction extends BaseAction<Company>{

    @RequestMapping("/selectOwn")
    public String selectOwn() {
        return Response.body(null);
    }

}
