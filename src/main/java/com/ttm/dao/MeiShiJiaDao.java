package com.ttm.dao;

import java.util.List;
import java.util.Map;

import com.ttm.orm.MeiShiJia;

public interface MeiShiJiaDao {
	/**
	 * 新增美食家模块
	 * @param safety
	 * @return
	 */
	public abstract boolean addMeiShiJia(MeiShiJia MeiShiJia);
	
	/**
	 * 更新美食家模块
	 * @param safety
	 * @return
	 */
	public abstract boolean updateMeiShiJia(MeiShiJia MeiShiJia);
	
	/**
	 * id 查询美食家模块
	 * @param id
	 * @return
	 */
	public abstract MeiShiJia findMeiShiJiaById(Integer id);
	
	/**
	 * 分页/条件/排序查询数据
	 * @param query
	 * @param sort
	 * @param pageing
	 * @return
	 */
	public abstract List<MeiShiJia> findMeiShiJiaByList(Map<String, Object> query, Map<String, Object> sort, Map<String, Integer> pageing);


}
