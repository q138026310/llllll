package com.dlts.hrms.service.base;

import java.util.List;

public interface BaseService<E> {

	public E get(String id);

	public E get(E entity);

	public List<E> select(E entity);

	public int delete(String id);

	public int deleteSelective(E entity);

	public int insert(E entity);

	public int updateSelective(E entity);

	public int update(E entity);

}
