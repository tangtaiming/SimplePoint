package com.ttm.biz;

import java.util.List;
import java.util.Map;

import com.ttm.orm.Preferential;

/**
 * 
 * <p>
 * 介绍：优惠模板数据
 * </p>
 * 
 * @author 唐太明
 * @date 2016年4月2日 下午10:24:46
 * @version 1.0
 */
public interface PreferentialBiz {

	/**
	 * 修改保存 优惠数据
	 * 	1.实现思路
	 * 		1.1 获取优惠Map key是对应优惠id value是 对应优惠名称
	 * 		1.2判断获取对应key 的value 是否有值，如果没有值 直接不进行任何操作，如果有数据接下来做1.3之后操作 
	 * 		1.3使用优惠id查询优惠数据，分两种情况 (1)查询有数据 (2)查询没有数据
	 * 		1.4(1)判断对应的优惠id是否有值，分两种情况(一)有值 :更新优惠数据 (二)没有值 保存数据
	 * @param preferential
	 * @return
	 */
	public abstract boolean saveOrUpdatePreferential(Map<String, Object> preferentialMap);
	
	/**
	 * 分页查询 查询优惠数据
	 * @param page
	 * @param size
	 * @return
	 */
	public abstract List<Preferential> findPreferentialList(Integer page, Integer size);

	/**
	 * 计算数量
	 * 
	 * @param Integer
	 *            数量
	 * @return
	 */
	public abstract Integer countReptileNumber();
	
	/**
	 * 排序查询所有数据
	 * @param sortName
	 * @param sortValue
	 * @return
	 */
	public abstract List<Preferential> findPreferentialList(String sortName, String sortValue);
	
	/**
	 * 解析 httpservletRequest 请求获取的字符串Map 并且解析成对应的Map
	 * @param requestJson
	 * @return
	 */
	public abstract Map<String, Object> parseRequestParams(String requestJson);
	
	/**
	 * 更新主页优惠模块信息
	 * @return
	 */
	public abstract boolean updateIndex();
	
}
