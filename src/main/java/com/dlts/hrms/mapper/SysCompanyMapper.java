package com.dlts.hrms.mapper;

import java.util.List;
import java.util.Map;

import com.dlts.hrms.entity.SysCompany;
import com.dlts.hrms.po.CompanyPo;

public interface SysCompanyMapper extends Mapper<SysCompany> {

    public int pageCount(Map<String, Object> map);

    public List<CompanyPo> pageSelect(Map<String, Object> map);

}
