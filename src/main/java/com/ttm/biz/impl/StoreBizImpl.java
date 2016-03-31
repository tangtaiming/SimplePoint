package com.ttm.biz.impl;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;

import com.ttm.biz.StoreBiz;
import com.ttm.dao.StoreDao;
import com.ttm.dao.impl.StoreDaoImpl;
import com.ttm.orm.School;
import com.ttm.orm.Store;
import com.ttm.util.Dumper;
import com.ttm.util.ServiceQueryHelper;

/**
 * 
 * <p>
 * 介绍
 * </p>
 * 
 * @author 唐太明
 * @date 2016年3月30日 下午11:39:31
 * @version 1.0
 */
public class StoreBizImpl implements StoreBiz {

	private StoreDao storeDao = new StoreDaoImpl();
	
	public boolean saveStore(Store store, School schoolId, Integer sortTypeId) {
		Store lastStore = findStoreById(store.getStoreId());
		boolean isFind = (lastStore != null ? true : false);
		if (isFind) {
			// reviewScores, salesQuantity, salesAllQuantity, sendThePrice,
			// distributionCost, shopHours, shoprReach, collectQuantity,
			// firstOrder, minusExempt, give, updateDate
			lastStore.setReviewScores(store.getReviewScores());
			lastStore.setSalesAllQuantity(store.getSalesAllQuantity());
			lastStore.setSendThePrice(store.getSendThePrice());
			lastStore.setDistributionCost(store.getDistributionCost());
			lastStore.setShopHours(store.getShopHours());
			lastStore.setShoprReach(store.getShoprReach());
			lastStore.setCollectQuantity(store.getCollectQuantity());
			lastStore.setFirstOrder(store.getFirstOrder());
			lastStore.setMinusExempt(store.getMinusExempt());
			lastStore.setGive(store.getGive());
			
			//修改时间
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			TimeZone zon = TimeZone.getTimeZone("Asia/Shanghai");
			Calendar calendar = Calendar.getInstance(zon);
			String updateDate = format.format(calendar.getTime());
			lastStore.setUpdateDate(updateDate);
			//这里进行月销售量判断 如果为0 可能是因为爬虫爬取数据 关闭获取不到对应的月销售量导致 所以这里如果为0就不进行 月销售量数据更新
			if (store.getSalesQuantity() != 0) {
				lastStore.setSalesQuantity(store.getSalesQuantity());
			}
			isFind = storeDao.updateStore(lastStore);
			System.out.println("update^^^^^^^^^^^^^^^^^^^^^^" + isFind);
		} else {
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			TimeZone zon = TimeZone.getTimeZone("Asia/Shanghai");
			Calendar calendar = Calendar.getInstance(zon);
			String creatdDate = format.format(calendar.getTime());
			store.setCreatdDate(creatdDate);
			// 0 代表爬虫 系统
			store.setCreatdId(0);
			store.setSortTypeId(sortTypeId);
			store.setSchoolId(schoolId);
			isFind = storeDao.saveStore(store);
			System.out.println("save^^^^^^^^^^^^^^^^^^^^^^" + isFind);
		}
		return isFind;
	}

	public boolean deleteStore(Integer id) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean updateStore(Store store) {
		// TODO Auto-generated method stub
		return false;
	}

	private Store findStoreById(Integer storeId) {
		Map<String, Object> query = new HashMap<String, Object>();
		ServiceQueryHelper.and(query, "storeId", storeId);
		return storeDao.findStoreById(query);
	}

	public Integer countReptileNumber() {
		return null;
	}

	public List<Store> findStoreList(Integer page, Integer size) {
		// TODO Auto-generated method stub
		return null;
	}

}
