package com.ttm.biz;

import java.util.List;

import com.ttm.orm.Safety;

/**
 * 
 * <p>
 * 介绍：安全模块业务
 * </p>
 * 
 * @author 唐太明
 * @date 2016年4月4日 下午3:14:52
 * @version 1.0
 */
public interface SafetyBiz {

	/**
	 * 查询对应安全类型的数据 按照对应的排序方式分页查询数据
	 * @param page
	 * @param size
	 * @param type
	 * @param sortName
	 * @return
	 */
	public abstract List<Safety> findSafetyList(Integer page, Integer size, Integer type, String sortName);
	
	/**
	 * 保存安全模块数据
	 * @param url
	 * @param title
	 * @param mark
	 * @param img
	 * @param creator
	 * @param creatorDate
	 * @return
	 */
	public abstract boolean saveSafety(String url, String title, Integer mark, String img, Integer creator, String creatorDate);
	
	/**
	 * id 查询安全模块数据
	 * @param id
	 * @return
	 */
	public abstract Safety findSafety(Integer id);
	
	/**
	 * id 删除安全模块数据
	 * @param id
	 * @return
	 */
	public abstract boolean deleteSafety(Integer id);
	
}
