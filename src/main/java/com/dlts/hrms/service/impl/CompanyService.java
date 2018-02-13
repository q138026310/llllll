package com.dlts.hrms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dlts.hrms.cm.Gap;
import com.dlts.hrms.cm.GlobalConstant;
import com.dlts.hrms.cm.Page;
import com.dlts.hrms.entity.SysCompany;
import com.dlts.hrms.ex.ServiceException;
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
        map.put("customCode", companyVo.getCustomCode());
        map.put("loginCompanyCode", companyVo.getLoginCompanyCode());
        map.setPage(companyVo.getStart(), companyVo.getLimit());

        List<CompanyPo> list = sysCompanyMapper.pageSelect(map.map());
        int count = sysCompanyMapper.pageCount(map.map());

        return Page.newPage(count, list);
    }

    @Override
    public List<SysCompany> select(CompanyVo companyVo) {
        return sysCompanyMapper.select(companyVo);
    }

    @Override
    public int insert(CompanyVo companyVo) {
        companyVo.setId(UuidUtils.getUuid());
        companyVo.setCreateTime(DateUtils.now());

        if (StringUtils.isBlank(companyVo.getParentCode())) {
            // 用户不输入上级公司编号则上级公司自动为登陆人所在公司的顶级公司
            if (companyVo.getLoginCompanyCode().equals(GlobalConstant.COMPANY_ROOT_CODE)) {
                companyVo.setParentCode(companyVo.getLoginCompanyCode());
            } else {
                companyVo.setParentCode(companyVo.getLoginCompanyCode().substring(0, 5));
            }
        } else {
            checkParentCode(companyVo);
        }

        checkNameRepeat(companyVo);

        checkCodeRepeat(companyVo);

        return sysCompanyMapper.insertTree(companyVo);
    }

    @Override
    public int update(CompanyVo companyVo) {
        return sysCompanyMapper.update(companyVo);
    }

    @Override
    public int delete(CompanyVo companyVo) {
        return sysCompanyMapper.deleteLogic(companyVo.getId());
    }

    /**
     * 上级编号权限检查
     * 
     * @param companyVo
     */
    private void checkParentCode(CompanyVo companyVo) {
        Gap map = Gap.newMap();
        map.put("loginCompanyCode", companyVo.getLoginCompanyCode());
        map.put("code", companyVo.getParentCode());
        int authCount = sysCompanyMapper.authCount(map.map());
        if (authCount == 0) {
            throw new ServiceException(GlobalConstant.ACCESS_DENIED.value);
        }
    }

    /**
     * 公司名称是否重复
     * 
     * @param companyVo
     * @return
     */
    public void checkNameRepeat(CompanyVo companyVo) {
        Gap map = Gap.newMap();
        map.put("loginCompanyCode", companyVo.getLoginCompanyCode());
        map.put("name", companyVo.getName());
        int authCount = sysCompanyMapper.authCount(map.map());
        if (authCount > 0) {
            throw new ServiceException(GlobalConstant.COMPANY_NAME_EXISTS.value);
        }
    }

    /**
     * 公司编号是否重复
     * 
     * @param companyVo
     * @return
     */
    public void checkCodeRepeat(CompanyVo companyVo) {
        Gap map = Gap.newMap();
        map.put("loginCompanyCode", companyVo.getLoginCompanyCode());
        map.put("customCode", companyVo.getCustomCode());
        int authCount = sysCompanyMapper.authCount(map.map());
        if (authCount > 0) {
            throw new ServiceException(GlobalConstant.COMPANY_CODE_EXISTS.value);
        }
    }

}
