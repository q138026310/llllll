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
        companyVo.setLoginCompanyCode(this.getSysCompany().getCode());
        return Response.body(companyService.page(companyVo));
    }

    @ResponseBody
    @RequestMapping("select")
    public String select(CompanyVo companyVo) {
        return Response.body(companyService.select(companyVo));
    }

    @ResponseBody
    @RequestMapping("get")
    public String get(CompanyVo companyVo) {
        return Response.body(companyService.get(companyVo));
    }

    @ResponseBody
    @RequestMapping("save")
    public String save(CompanyVo companyVo) {
        companyVo.setLoginCompanyCode(this.getSysCompany().getCode());
        companyVo.setCreateUserId(this.getUserId());
        return Response.body(companyService.insert(companyVo));
    }

    @ResponseBody
    @RequestMapping("modify")
    public String modify(CompanyVo companyVo) {
        companyVo.setLoginCompanyCode(this.getSysCompany().getCode());
        companyVo.setUpdateUserId(this.getUserId());
        return Response.body(companyService.update(companyVo));
    }

}
