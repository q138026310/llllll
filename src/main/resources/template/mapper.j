package com.dlts.hrms.mapper;

import java.util.List;

import com.dlts.hrms.entity.${entityName};

public interface ${entityName}Mapper {

	public ${entityName} getById(String id);

	public ${entityName} get(${entityName} entity);

	public List<${entityName}> select(${entityName} entity);

	public int delete(String id);

	public int deleteSelective(${entityName} entity);

	public int insert(${entityName} entity);

	public int updateSelective(${entityName} entity);

	public int update(${entityName} entity);

}
