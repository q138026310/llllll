package com.dlts.hrms.mapper;

import java.util.List;
import java.util.Map;

import com.dlts.hrms.entity.SysDepartment;
import com.dlts.hrms.po.DepartmentPo;

public interface SysDepartmentMapper extends Mapper<SysDepartment> {

    public int pageCount(Map<String, Object> map);

    public List<DepartmentPo> pageSelect(Map<String, Object> map);

    public int authCount(Map<String, Object> map);

    public int insertTree(SysDepartment entity);
}
