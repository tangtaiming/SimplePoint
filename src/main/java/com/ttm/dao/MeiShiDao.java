package com.ttm.dao;

import java.util.List;
import java.util.Map;

import com.ttm.orm.MeiShi;

public interface MeiShiDao {

	/**
	 * 新增美食模块
	 * @param safety
	 * @return
	 */
	public abstract boolean addMeiShi(MeiShi meiShi);
	
	/**
	 * 更新美食模块
	 * @param safety
	 * @return
	 */
	public abstract boolean updateMeiShi(MeiShi meiShi);
	
	/**
	 * id 查询美食模块
	 * @param id
	 * @return
	 */
	public abstract MeiShi findMeiShiById(Integer id);
	
	/**
	 * 分页/条件/排序查询数据
	 * @param query
	 * @param sort
	 * @param pageing
	 * @return
	 */
	public abstract List<MeiShi> findMeiShiByList(Map<String, Object> query, Map<String, Object> sort, Map<String, Integer> pageing);

	
}
