package com.ttm.biz;

import java.util.List;

import com.ttm.orm.MeiShiJia;

public interface MeiShiJiaBiz {
	/**
	 * 查询对应美食类型的数据 按照对应的排序方式分页查询数据
	 * @param page
	 * @param size
	 * @param type
	 * @param sortName
	 * @return
	 */
	public abstract List<MeiShiJia> findMeiShiJiaList(Integer page, Integer size, Integer type, String sortName);
	
	/**
	 * 保存美食模块数据
	 * @param url
	 * @param title
	 * @param mark
	 * @param img
	 * @param creator
	 * @param creatorDate
	 * @return
	 */
	public abstract boolean saveMeiShiJia(String url, String title, Integer mark, String img, Integer creator, String creatorDate);

	/**
	 * id 查询美食家信息
	 * @param id
	 * @return
	 */
	public abstract MeiShiJia findMeiShiJia(Integer id);
	
	/**
	 * 删除美食家信息
	 * @param id
	 * @return
	 */
	public abstract boolean deleteMeiShiJia(Integer id);
	
}
