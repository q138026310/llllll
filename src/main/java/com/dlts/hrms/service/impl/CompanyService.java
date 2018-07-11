package com.dlts.hrms.service.impl;

import com.dlts.hrms.domain.cm.GlobalConstant;
import com.dlts.hrms.domain.cm.PageResult;
import com.dlts.hrms.domain.cm.Unified;
import com.dlts.hrms.domain.entity.BaseEntity;
import com.dlts.hrms.domain.entity.Company;
import com.dlts.hrms.domain.vo.company.CompanyPageVo;
import com.dlts.hrms.mapper.CompanyMapper;
import com.dlts.hrms.service.base.BaseService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyService extends BaseService {

    @Autowired
    CompanyMapper companyMapper;

    public Unified<List<Company>> select(Company company) {
        return select(company,companyMapper);
    }

    public Unified<Integer> insert(Company company) {
        return insert(company,companyMapper);
    }

    public Unified<Integer> delete(Company company) {
        company.setStatus(GlobalConstant.Status.DELETE);
        return update(company);
    }

    public PageResult page(CompanyPageVo companyVo) {
        PageResult pageResult = PageResult.create();
        Page page = PageHelper.startPage(companyVo.getPage(),companyVo.getLimit());
        pageResult.setData(companyMapper.page(companyVo));
        pageResult.setCount(page.getTotal());
        return pageResult;
    }

    public Unified<Company> get(Company company) {
        return get(company,companyMapper);
    }

    public Unified<Integer> update(Company company) {
        return update(company,companyMapper);
    }

}
