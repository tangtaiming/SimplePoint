package com.ttm.biz;

import java.util.List;

import com.ttm.orm.MeiShi;
import com.ttm.orm.Safety;

/**
 * 
 * <p>介绍：美食模块</p>
 * @author 唐太明
 * @date 2016年4月7日 下午3:58:27
 * @version 1.0
 */
public interface MeiShiBiz {

	/**
	 * 查询对应美食类型的数据 按照对应的排序方式分页查询数据
	 * @param page
	 * @param size
	 * @param type
	 * @param sortName
	 * @return
	 */
	public abstract List<MeiShi> findMeiShiList(Integer page, Integer size, Integer type, String sortName);
	
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
	public abstract boolean saveMeiShi(String url, String title, Integer mark, String img, Integer creator, String creatorDate);
	
}
