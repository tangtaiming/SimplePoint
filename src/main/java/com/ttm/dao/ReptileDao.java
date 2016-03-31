package com.ttm.dao;

import java.util.List;
import java.util.Map;

import com.ttm.orm.Reptile;

/**
 * 
 * <p>介绍：爬虫起始URL 数据处理层</p>
 * @author 唐太明
 * @date 2016年3月28日 下午11:05:16
 * @version 1.0
 */
public interface ReptileDao {

	/**
	 * 添加url地址
	 * @param reptile
	 * @return
	 */
	public abstract boolean addReptile(Reptile reptile);
	
	/**
	 * 删除url地址
	 * @param reptile
	 * @return
	 */
	public abstract boolean deleteReptile(Reptile reptile);
	
	/**
	 * id查询对应数据
	 * @param id
	 * @return
	 */
	public abstract Reptile findReptileById(Integer id);
	
	/**
	 * 根据条件/分页/排序条件查询数据
	 * @return
	 */
	public abstract List<Reptile> findReptileByList(Map<String, Object> query, Map<String, Object> sort, Map<String, Integer> pageing);
	
}
