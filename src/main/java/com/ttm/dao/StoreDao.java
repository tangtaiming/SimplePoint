package com.ttm.dao;

import java.util.List;
import java.util.Map;

import com.ttm.orm.Store;

/**
 * <p>介绍：商店数据处理层</p>
 * @author 唐太明
 * @date 2016年3月30日 下午11:30:59
 * @version 1.0
 */
public interface StoreDao {

	/**
	 * 添加店铺
	 * @param store
	 * @return
	 */
	public abstract boolean saveStore(Store store);
	
	/**
	 * 修改店铺
	 * @param store
	 * @return
	 */
	public abstract boolean updateStore(Store store);
	
	/**
	 * 删除店铺
	 * @param store
	 * @return
	 */
	public abstract boolean deleteStore(Store store);
	
	/**
	 * 店铺Id 查询店铺
	 * @param id
	 * @return
	 */
	public abstract Store findStoreById(Map<String, Object> query);
	
	/**
	 * 查询/排序/分页查询 店铺集合
	 * @param query
	 * @param sort
	 * @param pageing
	 * @return
	 */
	public abstract List<Store> findStoreByList(Map<String, Object> query, Map<String, Object> sort, Map<String, Integer> pageing);
	
}
