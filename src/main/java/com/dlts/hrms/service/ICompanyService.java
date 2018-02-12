package com.dlts.hrms.service;

import java.util.List;

import com.dlts.hrms.cm.Page;
import com.dlts.hrms.entity.SysCompany;
import com.dlts.hrms.vo.CompanyVo;

/**
 * 
 * @author wuwen
 *
 */
public interface ICompanyService {

    public Page page(CompanyVo companyVo);

    public List<SysCompany> select(CompanyVo companyVo);

    public int insert(CompanyVo companyVo);

    public int update(CompanyVo companyVo);

    public int delete(CompanyVo companyVo);

    public int find(CompanyVo companyVo);

}
