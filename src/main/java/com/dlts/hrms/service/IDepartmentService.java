package com.dlts.hrms.service;

import java.util.List;

import com.dlts.hrms.cm.Page;
import com.dlts.hrms.entity.SysDepartment;
import com.dlts.hrms.po.DepartmentPo;
import com.dlts.hrms.vo.DepartmentVo;

public interface IDepartmentService {
    public Page<DepartmentPo> page(DepartmentVo departmentVo);

    public List<SysDepartment> select(DepartmentVo departmentVo);

    public SysDepartment getById(String departmentId);

    public SysDepartment get(DepartmentVo departmentVo);

    public int insert(DepartmentVo departmentVo);

    public int update(DepartmentVo departmentVo);

    public int delete(DepartmentVo departmentVo);
}
