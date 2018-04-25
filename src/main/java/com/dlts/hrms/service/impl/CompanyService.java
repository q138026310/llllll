package com.dlts.hrms.service.impl;

import com.dlts.hrms.domain.cm.GlobalConstant;
import com.dlts.hrms.domain.cm.PageResult;
import com.dlts.hrms.domain.cm.TkQuery;
import com.dlts.hrms.domain.cm.Unified;
import com.dlts.hrms.domain.entity.Company;
import com.dlts.hrms.mapper.CompanyMapper;
import com.dlts.hrms.utils.ServiceUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyService extends BaseService{

    @Autowired
    CompanyMapper companyMapper;

    public Unified<List<Company>> select(Company company) {
        Unified<List<Company>> unified = new Unified<List<Company>>();

        TkQuery query = ServiceUtils.getDefaultQuery(company);
        unified.setData(companyMapper.selectByExample(query.getExample()));
        return unified;
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

    public Unified<Object> get(Company company) {
        return get(company,companyMapper);
    }

    public Unified<Integer> update(Company company) {
        return update(company,companyMapper);
    }

}
