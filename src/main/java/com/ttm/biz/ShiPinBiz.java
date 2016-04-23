package com.ttm.biz;

import java.util.List;

import com.ttm.orm.ShiPin;

public interface ShiPinBiz {

	/**
	 * 查询对应视频模块的数据 按照对应的排序方式分页查询数据
	 * @param page
	 * @param size
	 * @param type
	 * @param sortName
	 * @return
	 */
	public abstract List<ShiPin> findShiPinList(Integer page, Integer size, Integer type, String sortName);
	
	/**
	 * 保存视频模块数据
	 * @param url
	 * @param title
	 * @param mark
	 * @param img
	 * @param creator
	 * @param creatorDate
	 * @return
	 */
	public abstract boolean saveShiPin(String url, String title, Integer mark, String img, Integer creator, String creatorDate);

	/**
	 * id 查询视频数据
	 * @param id
	 * @return
	 */
	public abstract ShiPin findShiPin(Integer id);
	
	/**
	 * id 删除视频信息
	 * @param id
	 * @return
	 */
	public abstract boolean deleteShiPin(Integer id);
	
}
