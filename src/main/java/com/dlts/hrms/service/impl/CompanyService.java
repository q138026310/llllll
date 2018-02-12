package com.dlts.hrms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dlts.hrms.cm.Gap;
import com.dlts.hrms.cm.GlobalConstant;
import com.dlts.hrms.cm.Page;
import com.dlts.hrms.entity.SysCompany;
import com.dlts.hrms.mapper.SysCompanyMapper;
import com.dlts.hrms.po.CompanyPo;
import com.dlts.hrms.service.ICompanyService;
import com.dlts.hrms.service.base.BaseService;
import com.dlts.hrms.utils.DateUtils;
import com.dlts.hrms.utils.StringUtils;
import com.dlts.hrms.utils.UuidUtils;
import com.dlts.hrms.vo.CompanyVo;

@Service("companyService")
public class CompanyService extends BaseService implements ICompanyService {

    @Autowired
    SysCompanyMapper sysCompanyMapper;

    @Override
    public Page page(CompanyVo companyVo) {
        Gap map = Gap.newMap();
        map.put("name", companyVo.getName());
        map.put("code", companyVo.getCode());
        map.setPage(companyVo.getStart(), companyVo.getLimit());

        List<CompanyPo> list = sysCompanyMapper.pageSelect(map.map());
        int count = sysCompanyMapper.pageCount(map.map());

        return Page.newPage(count, list);
    }

    @Override
    public int insert(CompanyVo companyVo) {
        companyVo.setId(UuidUtils.getUuid());
        companyVo.setCreateTime(DateUtils.now());

        if (StringUtils.isBlank(companyVo.getParentCode())) {
            companyVo.setParentCode(GlobalConstant.COMPANY_ROOT_CODE);
        } else {
            SysCompany entity = new SysCompany();
            entity.setCustomCode(companyVo.getParentCode());
            entity = sysCompanyMapper.get(entity);
            companyVo.setParentCode(entity.getCode());
        }

        return sysCompanyMapper.insertTree(companyVo);
    }

    @Override
    public int update(CompanyVo companyVo) {
        return 0;
    }

    @Override
    public int delete(CompanyVo companyVo) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int find(CompanyVo companyVo) {
        // TODO Auto-generated method stub
        return 0;
    }
}
