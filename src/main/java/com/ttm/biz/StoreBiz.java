package com.ttm.biz;

import java.util.List;

import com.ttm.orm.School;
import com.ttm.orm.Store;

/**
 * 
 * <p>
 * 介绍:商店业务逻辑接口
 * </p>
 * 
 * @author 唐太明
 * @date 2016年3月30日 下午11:31:24
 * @version 1.0
 */
public interface StoreBiz {

	/**
	 * 保存数据
	 * 
	 * @param store
	 * @return
	 */
	public abstract boolean saveStore(Store store, School schoolId, Integer sortTypeId);
	
	/**
	 * 商店id 删除数据
	 * @param id
	 * @return
	 */
	public abstract boolean deleteStore(Integer id);
	
	/**
	 * 修改商店数据
	 * @param store
	 * @return
	 */
	public abstract boolean updateStore(Store store);
	
	/**
	 * 计算数量
	 * 
	 * @param Integer
	 *            数量
	 * @return
	 */
	public abstract Integer countReptileNumber();
	
	/**
	 * 分页查询数据
	 * @param page
	 * @param size
	 * @return
	 */
	public abstract List<Store> findStoreList(Integer page, Integer size);
	
	/**
	 * 分页/排序条件查询数据 默认使用倒序排
	 * @param page
	 * @param size
	 * @param storeName
	 * @return
	 */
	public abstract List<Store> findStoreList(Integer page, Integer size, String storeName);
	
	/**
	 * 2个条件查询商店集合信息
	 * @return
	 */
	public abstract List<Store> findStoreDuoTiaoJian(String p1, String p2, int page, int size, String sort, String sortName);
	
	/**
	 * 学校Id查询优惠数据
	 * @param schoolId
	 * @param page
	 * @param size
	 * @param storeName
	 * @return
	 */
	public abstract List<Store> findStoreList(Integer schoolId, Integer page, Integer size, String storeName);
	
	/**
	 * 主键查询 店铺信息
	 * @param id
	 * @return
	 */
	public abstract Store findById(Integer id);
	
	/**
	 * 分页搜索店铺
	 * @param sea
	 * @param page
	 * @param size
	 * @return
	 */
	public abstract List<Store> search(String sea, Integer schoolId, Integer page, Integer size);
	
}
