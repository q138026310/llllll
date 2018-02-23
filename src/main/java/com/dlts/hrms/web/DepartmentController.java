package com.dlts.hrms.web;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dlts.hrms.cm.Response;
import com.dlts.hrms.service.IDepartmentService;
import com.dlts.hrms.vo.DepartmentVo;
import com.dlts.hrms.web.base.BaseController;

@Controller
@RequestMapping("department")
public class DepartmentController extends BaseController {
    @Resource(name = "departmentService")
    IDepartmentService departmentService;

    @ResponseBody
    @RequestMapping("page")
    public String page(DepartmentVo departmentVo) {
        departmentVo.setLoginCompanyId(this.getSysUser().getCompanyId());
        return Response.body(departmentService.page(departmentVo));
    }

    @ResponseBody
    @RequestMapping("select")
    public String select(DepartmentVo departmentVo) {
        return Response.body(departmentService.select(departmentVo));
    }

    @ResponseBody
    @RequestMapping("get")
    public String get(DepartmentVo departmentVo) {
        return Response.body(departmentService.get(departmentVo));
    }

    @ResponseBody
    @RequestMapping("save")
    public String save(DepartmentVo departmentVo) {
        departmentVo.setLoginCompanyId(this.getSysUser().getCompanyId());
        departmentVo.setCreateUserId(this.getUserId());
        return Response.body(departmentService.insert(departmentVo));
    }

    @ResponseBody
    @RequestMapping("modify")
    public String modify(DepartmentVo departmentVo) {
        departmentVo.setLoginCompanyId(this.getSysUser().getCompanyId());
        departmentVo.setUpdateUserId(this.getUserId());
        return Response.body(departmentService.update(departmentVo));
    }
}
