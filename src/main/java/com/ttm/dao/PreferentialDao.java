package com.ttm.dao;

import java.util.List;
import java.util.Map;

import com.ttm.orm.Preferential;

/**
 * 
 * <p>
 * 介绍：优惠模块数据层
 * </p>
 * 
 * @author 唐太明
 * @date 2016年4月2日 下午8:29:06
 * @version 1.0
 */
public interface PreferentialDao {

	/**
	 * 添加 优惠
	 * 
	 * @param preferential
	 * @return
	 */
	public abstract boolean addPreferential(Preferential preferential);

	/**
	 * 修改 优惠
	 * 
	 * @param preferential
	 * @return
	 */
	public abstract boolean updatePreferential(Preferential preferential);
	
	/**
	 * id 主键查询 优惠
	 * @param id
	 * @return
	 */
	public abstract Preferential findPreferentialById(Integer id);

	/**
	 * 分页/排序/条件查询
	 * 
	 * @param query
	 * @param sort
	 * @param pageing
	 * @return
	 */
	public abstract List<Preferential> findPreferentialByList(Map<String, Object> query, Map<String, Object> sort,
			Map<String, Integer> pageing);

}
