package com.ttm.dao;

import java.util.List;
import java.util.Map;

import com.ttm.orm.ShuiGuo;

/**
 * 
 * <p>
 * 介绍:水果数据处理层
 * </p>
 * 
 * @author 唐太明
 * @date 2016年4月17日 下午2:59:24
 * @version 1.0
 */
public interface ShuiGuoDao {
	
	/**
	 * 新增水果模块
	 * 
	 * @param safety
	 * @return
	 */
	public abstract boolean addShuiGuo(ShuiGuo shuiGuo);

	/**
	 * 更新水果模块
	 * 
	 * @param safety
	 * @return
	 */
	public abstract boolean updateShuiGuo(ShuiGuo shuiGuo);

	/**
	 * id 查询水果模块
	 * 
	 * @param id
	 * @return
	 */
	public abstract ShuiGuo findShuiGuoById(Integer id);

	/**
	 * 分页/条件/排序查询数据
	 * 
	 * @param query
	 * @param sort
	 * @param pageing
	 * @return
	 */
	public abstract List<ShuiGuo> findShuiGuoByList(Map<String, Object> query, Map<String, Object> sort,
			Map<String, Integer> pageing);

	
	/**
	 * 删除水果信息
	 * @param shuiGuo
	 * @return
	 */
	public abstract boolean deleteShuiGuo(ShuiGuo shuiGuo);
	
}
