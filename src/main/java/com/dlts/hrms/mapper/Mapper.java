package com.dlts.hrms.mapper;

import java.util.List;

/**
 * 基础mapper
 * 
 * @author wuwen
 *
 * @param <A> entity
 */
public interface Mapper<A> {

    /**
     * 基础功能
     * 
     * 根据表id获取表数据
     * 
     * @author wuwen
     * @param id
     * @return
     */
    public A getById(String id);

    /**
     * 根据表信息获取表数据-单条
     * 
     * @author wuwen
     * @param entity
     * @return
     */
    public A get(A entity);

    /**
     * 根据表数据获取表数据-多条
     * 
     * @author wuwen
     * @param entity
     * @return
     */
    public List<A> select(A entity);

    /**
     * 根据表数据count
     * 
     * @author wuwen
     * @param entity
     * @return
     */
    public int count(A entity);

    /**
     * 根据表id删除表信息
     * 
     * @author wuwen
     * @param id
     * @return
     */
    public int delete(String id);

    /**
     * 根据表id逻辑删除
     * 
     * @param id
     * @return
     */
    public int deleteLogic(String id);

    /**
     * 添加
     * 
     * @author wuwen
     * @param entity
     * @return
     */
    public int insert(A entity);

    /**
     * 更新--更新所有列
     * 
     * @author wuwen
     * @param entity
     * @return
     */
    public int update(A entity);

    /**
     * 根据表信息删除表数据
     * 
     * @author wuwen
     * @param entity
     * @return
     */
    public int deleteSelective(A entity);

    /**
     * 更新--更新有数据的列
     * 
     * @author wuwen
     * @param entity
     * @return
     */
    public int updateSelective(A entity);

}
