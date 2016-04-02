package com.ttm.biz.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;

import org.apache.commons.collections.CollectionUtils;

import com.ttm.biz.StoreBiz;
import com.ttm.dao.StoreDao;
import com.ttm.dao.impl.StoreDaoImpl;
import com.ttm.orm.School;
import com.ttm.orm.Store;
import com.ttm.util.Page;
import com.ttm.util.PageUtil;
import com.ttm.util.ServicePaginationHelper;
import com.ttm.util.ServiceQueryHelper;
import com.ttm.util.ServiceSorterHelper;

/**
 * 
 * <p>
 * 介绍： 商店业务层
 * </p>
 * 
 * @author 唐太明
 * @date 2016年3月30日 下午11:39:31
 * @version 1.0
 */
public class StoreBizImpl implements StoreBiz {

	private StoreDao storeDao = new StoreDaoImpl();
	
	private Page page;

	private List<Integer> showPage;

	/**
	 * 默认当前页
	 */
	private int pageNumber = 1;

	/**
	 * 每页显示数量
	 */
	private int size = 1;

	/**
	 * 总共数量
	 */
	private int totalNumber = 1;

	/**
	 * 前后显示数量
	 */
	private int pageRange = 5;
	
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
		Store store = storeDao.findStoreById(id);
		if (store != null) {
			return storeDao.deleteStore(store);
		}
		return false;
	}

	public boolean updateStore(Store store) {
		return false;
	}

	private Store findStoreById(Integer storeId) {
		Map<String, Object> query = new HashMap<String, Object>();
		ServiceQueryHelper.and(query, "storeId", storeId);
		return storeDao.findStoreById(query);
	}

	public Integer countReptileNumber() {
		List<Store> storesList = storeDao.findStoreByList(null, null, null);
		if (CollectionUtils.isNotEmpty(storesList)) {
			return storesList.size();
		}
		return 1;
	}

	public List<Store> findStoreList(Integer page, Integer size) {
		Map<String, Integer> pageing = ServicePaginationHelper.build(size, page);
		Map<String, Object> sort = ServiceSorterHelper.build("id", ServiceSorterHelper.ASC);
		List<Store> storesList = storeDao.findStoreByList(null, sort, pageing);
		PageUtil pageUtil = PageUtil.getPageUtil();
		if (CollectionUtils.isNotEmpty(storesList)) {
			pageNumber = page;
			this.size = size;
			totalNumber = countReptileNumber();
		} else {
			System.out.println("没有查询出数据...");
		}
		this.page = pageUtil.createPage(pageNumber, size, totalNumber, pageRange);
		countShowPage(this.page.getRangeStart(), this.page.getRangeEnd());
		return storesList;
	}
	
	/**
	 * 计算显示分页 
	 * <p>showPage集合在这里设置值</p>
	 * 
	 * @param start
	 * @param end
	 */
	private void countShowPage(Integer start, Integer end) {
		List<Integer> showPage = new ArrayList<Integer>();
		for (int x = start; x <= end; x++) {
			showPage.add(x);
		}
		setShowPage(showPage);
	}

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

	public List<Integer> getShowPage() {
		return showPage;
	}

	public void setShowPage(List<Integer> showPage) {
		this.showPage = showPage;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

}
