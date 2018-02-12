package com.dlts.hrms.web;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dlts.hrms.cm.Response;
import com.dlts.hrms.service.ICompanyService;
import com.dlts.hrms.vo.CompanyVo;
import com.dlts.hrms.web.base.BaseController;

@Controller
@RequestMapping("company")
public class CompanyController extends BaseController {

    @Resource(name = "companyService")
    ICompanyService companyService;

    @ResponseBody
    @RequestMapping("page")
    public String page(CompanyVo companyVo) {
        return Response.body(companyService.page(companyVo));
    }

    @ResponseBody
    @RequestMapping("save")
    public String save(CompanyVo companyVo) {
        companyVo.setCreateUserId(this.getUserId());
        return Response.body(companyService.insert(companyVo));
    }

}
