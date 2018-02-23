package com.dlts.hrms.service;

import java.util.List;

import com.dlts.hrms.cm.Page;
import com.dlts.hrms.entity.SysCompany;
import com.dlts.hrms.po.CompanyPo;
import com.dlts.hrms.vo.CompanyVo;

/**
 * 
 * @author wuwen
 *
 */
public interface ICompanyService {

    public Page<CompanyPo> page(CompanyVo companyVo);

    public List<SysCompany> select(CompanyVo companyVo);

    public SysCompany getById(String companyId);

    public SysCompany get(CompanyVo companyVo);

    public int insert(CompanyVo companyVo);

    public int update(CompanyVo companyVo);

    public int delete(CompanyVo companyVo);

}
