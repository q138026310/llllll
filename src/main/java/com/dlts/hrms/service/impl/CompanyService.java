package com.dlts.hrms.service.impl;

import com.dlts.hrms.domain.cm.GlobalConstant;
import com.dlts.hrms.domain.cm.PageResult;
import com.dlts.hrms.domain.cm.Unified;
import com.dlts.hrms.domain.entity.Company;
import com.dlts.hrms.mapper.CompanyMapper;
import com.dlts.hrms.service.base.BaseService;
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

    public Unified<PageResult> page(Company company) {
        return page(company,companyMapper);
    }

    public Unified<Company> get(Company company) {
        return get(company,companyMapper);
    }

    public Unified<Integer> update(Company company) {
        return update(company,companyMapper);
    }

}
