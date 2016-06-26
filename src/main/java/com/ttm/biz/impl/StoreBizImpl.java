package com.ttm.biz.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import com.ttm.biz.StoreBiz;
import com.ttm.dao.StoreDao;
import com.ttm.dao.impl.StoreDaoImpl;
import com.ttm.enums.StoreEnum;
import com.ttm.orm.School;
import com.ttm.orm.Store;
import com.ttm.util.Dumper;
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

	private static final Logger log = Logger.getLogger(StoreBizImpl.class);

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
	
//	@SuppressWarnings("unchecked")
//	public boolean saveOrUpdateStore(Map<String, Object> preferentialMap) {
//		String firstKey = "0";
//		Map<String, Object> firstMap = (Map<String, Object>) preferentialMap.get(firstKey);
//		String name = (String) firstMap.get("name");
//		
//		//循环获取
//		StringBuffer params = new StringBuffer();
//		Integer number = 0;
//		for (String mKey : preferentialMap.keySet()) {
//			if (mKey.equals(firstKey)) {
//				continue;
//			}
//			
//			Map<String, Object> mMap = (Map<String, Object>) preferentialMap.get(mKey);
//			String attName = (String) mMap.get("fix");
//			String symbol = (String) mMap.get("sign");
//			String attValue = "";
//			if (!symbol.equals("not")) {
//				attValue = (String) mMap.get("value");
//			}
//			
//			if (symbol.equals("gt")) {
//				params.append(attName);
//				params.append(" > ");
//				params.append(attValue);
//			} else if (symbol.equals("not")) {
//				params.append(attName);
//				params.append(" is not null ");
//			}
//			
//			if (preferentialMap.size() >= number) {
//				params.append(" and ");
//			}
// 			number++;
//		}
//		String sort = "updateDate";
//		pageNumber = 0;
//		size = 50;
//		storeDao.findStoreListMore(params.toString(), sort, pageNumber, size);
//		return true;
//	}
	

	public boolean saveStore(Store store, School schoolId, Integer sortTypeId) {
		Store lastStore = findStoreById(store.getStoreId(), schoolId.getId());
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
			lastStore.setRecruitment(store.getRecruitment());

			// 修改时间
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			TimeZone zon = TimeZone.getTimeZone("Asia/Shanghai");
			Calendar calendar = Calendar.getInstance(zon);
			String updateDate = format.format(calendar.getTime());
			lastStore.setUpdateDate(updateDate);
			// 这里进行月销售量判断 如果为0 可能是因为爬虫爬取数据 关闭获取不到对应的月销售量导致 所以这里如果为0就不进行 月销售量数据更新
			if (store.getSalesQuantity() != 0) {
				lastStore.setSalesQuantity(store.getSalesQuantity());
			}
			
			if (lastStore.getSchoolId().getId() != schoolId.getId()) {
				isFind = extractSaveStore(store, schoolId, sortTypeId);
			} else {
				isFind = storeDao.updateStore(lastStore);
				System.out.println("update^^^^^^^^^^^^^^^^^^^^^^" + isFind);
			}
		} else {
			isFind = extractSaveStore(store, schoolId, sortTypeId);
		}
		return isFind;
	}

	/**
	 * 保存数据
	 * @param store
	 * @param schoolId
	 * @param sortTypeId
	 * @return
	 */
	private boolean extractSaveStore(Store store, School schoolId, Integer sortTypeId) {
		boolean isFind;
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

	private Store findStoreById(Integer storeId, Integer schoolId) {
		Map<String, Object> query = new HashMap<String, Object>();
		ServiceQueryHelper.and(query, "storeId", storeId);
		ServiceQueryHelper.and(query, "schoolId.id", schoolId);
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
			log.warn("没有查询出数据...");
		}
		this.page = pageUtil.createPage(pageNumber, size, totalNumber, pageRange);
		countShowPage(this.page.getRangeStart(), this.page.getRangeEnd());
		return storesList;
	}

	public List<Store> findStoreList(Integer page, Integer size, String storeName) {
		Map<String, Integer> pageing = ServicePaginationHelper.build(size, page);
		Map<String, Object> sort = ServiceSorterHelper.build(storeName, ServiceSorterHelper.DESC);
		List<Store> storesList = storeDao.findStoreByList(null, sort, pageing);
		if (CollectionUtils.isNotEmpty(storesList)) {
			log.warn("没有查询出数据...");
		}
		return storesList;
	}

	public List<Store> search(String sea, Integer schoolId, Integer page, Integer size) {
		page = (page - 1) * size;
		List<Store> storeList = storeDao.findStoreSearch(sea, schoolId, page, size);
		if (CollectionUtils.isEmpty(storeList)) {
			log.warn("没有查询出数据..");
		}
		return storeList;
	}

	
	/*******************************************************************************************************/

	public List<Store> findStoreDuoTiaoJian(String p1, String p2, int page, int size, String sort, String sortName) {
		List<Criterion> criterionsList = new ArrayList<Criterion>();
		try {
			Criterion criterion = setQuery(p1);
			Criterion criterion2 = setQuery(p2);
			if (criterion != null) {
				criterionsList.add(criterion);
			}
			if (criterion2 != null) {
				criterionsList.add(criterion2);
			}
		} catch (Exception e) {
			log.error("获取查询对象出现错误.", e);
		}
		Map<String, Integer> pageing = ServicePaginationHelper.build(size, page);
		Map<String, Object> sortMap = ServiceSorterHelper.build(sortName, sort);
		List<Store> storesList = storeDao.findStoreLianGeTiaoJianChaXun(criterionsList, sortMap, pageing);
		if (CollectionUtils.isEmpty(storesList)) {
			log.warn("请求数据为空.");
		}
		return storesList;
	}
	
	public List<Store> findStoreList(Integer schoolId, Integer page, Integer size, String storeName) {
		Map<String, Object> query = new HashMap<String, Object>();
		Map<String, Integer> pageing = ServicePaginationHelper.build(size, page);
		Map<String, Object> sort = ServiceSorterHelper.build(storeName, ServiceSorterHelper.ASC);
		ServiceQueryHelper.and(query, "schoolId.id", schoolId);
		
		List<Store> storesList = storeDao.findStoreByList(query, sort, pageing);
		if (CollectionUtils.isEmpty(storesList)) {
			log.warn("查询数据为空.");
		}
		return storesList;
	}
	
	public Store findById(Integer id) {
		return storeDao.findStoreById(id);
	}
	
	// *************************************其他方法**************************************
	private Criterion setQuery(String params) throws Exception {
		if (StringUtils.isEmpty(params)) {
			log.warn("参数为空.");
			return null;
		}

		String[] p = StringUtils.split(params, "_");
		//查询列
		String paramName = p[0];
		//使用符号
		String op = p[1];
		String paramValue = "";
		if (p.length == 3) {
			//查询参数
			paramValue = p[2];
		}

		boolean isName = false;
		for (StoreEnum se : StoreEnum.values()) {
			if (paramName.equals(se.getStoreName())) {
				isName = true;
				break;
			}
		}
		
		if (!isName) {
			throw new Exception("请求列不存在." + paramName);
		}
		
		if (op.equals("not")) {
			return Restrictions.isNotNull(paramName);
		} else if (op.equals("eq")) {
			if (paramValue.contains(".")) {
				return Restrictions.eq(paramName, Double.valueOf(paramValue));
			} else {
				return Restrictions.eq(paramName, Integer.valueOf(paramValue));
			}
		} else if (op.equals("ge")) {
			//reviewScores
			if (paramName.equals("reviewScores")) {
				return Restrictions.ge(paramName, Double.valueOf(paramValue));
			}
			
			if (paramValue.contains(".")) {
				return Restrictions.ge(paramName, Double.valueOf(paramValue));
			} else {
				return Restrictions.ge(paramName, Integer.valueOf(paramValue));
			}
		} else {
			throw new Exception("传入参数有问题:" + paramValue);
		}
		
	}

	/**
	 * 计算显示分页
	 * <p>
	 * showPage集合在这里设置值
	 * </p>
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
