package com.dlts.hrms.web.system;

import com.dlts.hrms.domain.cm.Response;
import com.dlts.hrms.domain.entity.Company;
import com.dlts.hrms.domain.entity.User;
import com.dlts.hrms.domain.vo.company.CompanyPageVo;
import com.dlts.hrms.service.impl.CompanyService;
import com.dlts.hrms.web.BaseAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/company")
public class CompanyAction extends BaseAction {

    @Autowired
    CompanyService companyService;

    @RequestMapping("/insert")
    public String insert(Company company) {
        return Response.body(companyService.insert(company));
    }

    @RequestMapping("/update")
    public String update(Company company) {
        return Response.body(companyService.update(company));
    }

    @RequestMapping("/delete")
    public String delete(Company company) {
        return Response.body(companyService.delete(company));
    }

    @RequestMapping("/page")
    public String page(CompanyPageVo companyPageVo) {
        return Response.body(companyService.page(companyPageVo));
    }

    @RequestMapping("/select")
    public String select(Company company) {
        return Response.body(companyService.select(company));
    }

    @RequestMapping("/get")
    public String get(Company company) {
        return Response.body(companyService.get(company));
    }

}
