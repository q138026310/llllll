package com.dlts.hrms.web;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dlts.hrms.cm.Response;
import com.dlts.hrms.service.ICompanyService;
import com.dlts.hrms.vo.CompanyVo;

@Controller
@RequestMapping("company")
public class CompanyController {

    @Resource(name = "companyService")
    ICompanyService companyService;

    @ResponseBody
    @RequestMapping("page")
    public String page(CompanyVo companyVo) {
        return Response.body(companyService.page(companyVo));
    }
}
