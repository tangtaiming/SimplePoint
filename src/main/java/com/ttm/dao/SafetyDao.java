package com.ttm.dao;

import java.util.List;
import java.util.Map;

import com.ttm.orm.Safety;

/**
 * 
 * <p>
 * 介绍：安全模块
 * </p>
 * 
 * @author 唐太明
 * @date 2016年4月4日 下午2:50:05
 * @version 1.0
 */
public interface SafetyDao {

	/**
	 * 新增安全模块
	 * @param safety
	 * @return
	 */
	public abstract boolean addSafety(Safety safety);
	
	/**
	 * 更新安全模块
	 * @param safety
	 * @return
	 */
	public abstract boolean updateSafety(Safety safety);
	
	/**
	 * id 查询安全模块信息
	 * @param id
	 * @return
	 */
	public abstract Safety findSafetyById(Integer id);
	
	/**
	 * 分页/条件/排序查询数据
	 * @param query
	 * @param sort
	 * @param pageing
	 * @return
	 */
	public abstract List<Safety> findSafetyByList(Map<String, Object> query, Map<String, Object> sort, Map<String, Integer> pageing);

	/**
	 * 删除食品安全数据
	 * @param safety
	 * @return
	 */
	public abstract boolean deleteSafety(Safety safety);
}
