package com.ttm.dao;

import java.util.List;
import java.util.Map;

import com.ttm.orm.ShiPin;

public interface ShiPinDao {

	/**
	 * 新增视频模块
	 * @param safety
	 * @return
	 */
	public abstract boolean addShiPin(ShiPin shiPin);
	
	/**
	 * 更新视频模块
	 * @param safety
	 * @return
	 */
	public abstract boolean updateShiPin(ShiPin shiPin);
	
	/**
	 * id 查询视频模块
	 * @param id
	 * @return
	 */
	public abstract ShiPin findShiPinById(Integer id);
	
	/**
	 * 分页/条件/排序查询数据
	 * @param query
	 * @param sort
	 * @param pageing
	 * @return
	 */
	public abstract List<ShiPin> findShiPinByList(Map<String, Object> query, Map<String, Object> sort, Map<String, Integer> pageing);

	
}
