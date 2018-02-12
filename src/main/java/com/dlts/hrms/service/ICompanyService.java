package com.dlts.hrms.service;

import com.dlts.hrms.cm.Page;
import com.dlts.hrms.vo.CompanyVo;

public interface ICompanyService {

    public Page page(CompanyVo companyVo);

    public int insert(CompanyVo companyVo);

    public int update(CompanyVo companyVo);

    public int delete(CompanyVo companyVo);

    public int find(CompanyVo companyVo);

}
