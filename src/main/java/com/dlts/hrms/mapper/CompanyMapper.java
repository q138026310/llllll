package com.dlts.hrms.mapper;

import com.dlts.hrms.config.LmsMapper;
import com.dlts.hrms.domain.entity.Company;
import com.dlts.hrms.domain.entity.User;
import com.dlts.hrms.domain.po.company.CompanyPagePo;
import com.dlts.hrms.domain.vo.company.CompanyPageVo;

import java.util.List;

public interface CompanyMapper extends LmsMapper<Company> {

    public List<CompanyPagePo> page(CompanyPageVo companyPageVo);

}
