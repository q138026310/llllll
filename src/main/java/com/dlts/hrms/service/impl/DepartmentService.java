package com.dlts.hrms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dlts.hrms.cm.Gap;
import com.dlts.hrms.cm.GlobalConstant;
import com.dlts.hrms.cm.Page;
import com.dlts.hrms.entity.SysDepartment;
import com.dlts.hrms.ex.ServiceException;
import com.dlts.hrms.mapper.SysDepartmentMapper;
import com.dlts.hrms.po.DepartmentPo;
import com.dlts.hrms.service.IDepartmentService;
import com.dlts.hrms.utils.StringUtils;
import com.dlts.hrms.vo.DepartmentVo;

@Service("departmentService")
public class DepartmentService implements IDepartmentService {

    @Autowired
    SysDepartmentMapper sysDepartmentMapper;

    @Override
    public Page<DepartmentPo> page(DepartmentVo departmentVo) {
        Gap map = Gap.newMap();
        map.put("name", departmentVo.getName());
        // map.put("customCode", companyVo.getCustomCode());
        // map.put("loginCompanyCode", companyVo.getLoginCompanyCode());
        map.setPage(departmentVo.getStart(), departmentVo.getLimit());

        List<DepartmentPo> list = sysDepartmentMapper.pageSelect(map.map());
        int count = sysDepartmentMapper.pageCount(map.map());

        return Page.newPage(count, list);
    }

    @Override
    public List<SysDepartment> select(DepartmentVo departmentVo) {
        return sysDepartmentMapper.select(departmentVo);
    }

    @Override
    public SysDepartment getById(String departmentId) {
        return sysDepartmentMapper.getById(departmentId);
    }

    @Override
    public SysDepartment get(DepartmentVo departmentVo) {
        return sysDepartmentMapper.get(departmentVo);
    }

    @Override
    public int insert(DepartmentVo departmentVo) {
        return sysDepartmentMapper.insertTree(departmentVo);
    }

    @Override
    public int update(DepartmentVo departmentVo) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int delete(DepartmentVo departmentVo) {
        if (StringUtils.isBlank(departmentVo.getId())) {
            throw new ServiceException(GlobalConstant.PARAM_ERROR.value);
        }
        return sysDepartmentMapper.deleteLogic(departmentVo.getId());
    }

}
