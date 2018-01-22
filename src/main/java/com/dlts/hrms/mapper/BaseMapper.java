package com.dlts.hrms.mapper;

import java.util.List;

public interface BaseMapper<E> {

	public E getById(String id);

	public E get(E entity);

	public List<E> select(E entity);

	public int delete(String id);

	public int deleteSelective(E entity);

	public int insert(E entity);

	public int updateSelective(E entity);

	public int update(E entity);
}
