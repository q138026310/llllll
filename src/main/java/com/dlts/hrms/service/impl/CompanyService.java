package com.dlts.hrms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dlts.hrms.cm.Gap;
import com.dlts.hrms.cm.Page;
import com.dlts.hrms.mapper.SysCompanyMapper;
import com.dlts.hrms.po.CompanyPo;
import com.dlts.hrms.service.ICompanyService;
import com.dlts.hrms.service.base.BaseService;
import com.dlts.hrms.vo.CompanyVo;

@Service("companyService")
public class CompanyService extends BaseService implements ICompanyService {

    @Autowired
    SysCompanyMapper sysCompanyMapper;

    @Override
    public Page page(CompanyVo companyVo) {
        Gap map = Gap.newMap(companyVo);

        List<CompanyPo> list = sysCompanyMapper.pageSelect(map.map());
        int count = sysCompanyMapper.pageCount(map.map());

        return Page.newPage(count, list);
    }
}
