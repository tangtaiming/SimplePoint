package com.ttm.biz;

import java.util.List;

import com.ttm.orm.ShuiGuo;

public interface ShuiGuoBiz {
	
	/**
	 * 查询对应水果类型的数据 按照对应的排序方式分页查询数据
	 * 
	 * @param page
	 * @param size
	 * @param type
	 * @param sortName
	 * @return
	 */
	public abstract List<ShuiGuo> findShuiGuoList(Integer page, Integer size, Integer type, String sortName);

	/**
	 * 保存水果模块数据
	 * 
	 * @param url
	 * @param title
	 * @param mark
	 * @param img
	 * @param creator
	 * @param creatorDate
	 * @return
	 */
	public abstract boolean saveShuiGuo(String url, String title, Integer mark, String img, Integer creator,
			String creatorDate);

}
