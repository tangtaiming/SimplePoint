package com.ttm.biz.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.apache.xmlbeans.impl.jam.mutable.MPackage;

import com.ttm.biz.PreferentialBiz;
import com.ttm.dao.PreferentialDao;
import com.ttm.dao.impl.PreferentialDaoImpl;
import com.ttm.orm.Preferential;
import com.ttm.util.Page;
import com.ttm.util.PageUtil;
import com.ttm.util.ServicePaginationHelper;
import com.ttm.util.ServiceSorterHelper;
/**
 * 
 * <p>介绍:优惠业务层</p>
 * @author 唐太明
 * @date 2016年4月2日 下午11:19:08
 * @version 1.0
 */
public class PreferentialBizImpl implements PreferentialBiz {
	
	private static final Logger log = Logger.getLogger(PreferentialBizImpl.class);
	
	private PreferentialDao preferentialDao = new PreferentialDaoImpl();
	
	private Preferential preferential;
	
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

	public boolean saveOrUpdatePreferential(Map<String, Object> preferentialMap) {
		if (MapUtils.isEmpty(preferentialMap)) {
			log.info("传入参数 为空...");
			return false;
		}
		for (String key : preferentialMap.keySet()) {
			String value = (String) preferentialMap.get(key);
			if (StringUtils.isEmpty(value)) {
				continue;
			}
			
			//如果为true 才进行数据保存和修改操作  这里的key 存储的就是 id
			if (findPreferential(Integer.valueOf(key))) {
				preferential.setId(Integer.valueOf(key));
				preferential.setName(value);
				//1 代表唐太泰明
				preferential.setCreatdId(1);
				
				//获取系统当前时间
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				String creatdDate = format.format(new Date());
				preferential.setCreatdDate(creatdDate);
				
				if (preferentialDao.addPreferential(preferential)) {
					log.info("preferential 保存数据成功...");
				} else {
					log.error("preferential 保存数据失败...");
				}
			} else {
				preferential.setName(value);
				if (preferentialDao.updatePreferential(preferential)) {
					log.info("preferential 修改数据成功...");
				} else {
					log.error("preferential 修改数据失败...");
				}
			}
		}
		return true;
	}

	@Override
	public List<Preferential> findPreferentialList(Integer page, Integer size) {
		Map<String, Integer> pageing = ServicePaginationHelper.build(size, page);
		Map<String, Object> sort = ServiceSorterHelper.build("id", ServiceSorterHelper.ASC);
		List<Preferential> preferentialsList = preferentialDao.findPreferentialByList(null, sort, pageing);
		
		PageUtil pageUtil = PageUtil.getPageUtil();
		if (CollectionUtils.isNotEmpty(preferentialsList)) {
			this.totalNumber = countReptileNumber();
			this.size = size;
			this.pageNumber = page;
		}
		this.page = pageUtil.createPage(this.pageNumber, this.size, this.totalNumber, this.pageRange);
		countShowPage(this.page.getRangeStart(), this.page.getRangeEnd());
		return preferentialsList;
	}

	public Integer countReptileNumber() {
		List<Preferential> preferentials = preferentialDao.findPreferentialByList(null, null, null);
		if (CollectionUtils.isNotEmpty(preferentials)) {
			return preferentials.size();
		}
		return 1;
	}

	public List<Preferential> findPreferentialList(String sortName, String sortValue) {
		Map<String, Object> sort = ServiceSorterHelper.build(sortName, sortValue);
		List<Preferential> preferentialsList = preferentialDao.findPreferentialByList(null, sort, null);
		if (CollectionUtils.isNotEmpty(preferentialsList)) {
			log.info("排序查询出数据...");
		}
		return preferentialsList;
	}
	

	/**
	 * id查询是否有对应的优惠数据
	 * 	true 查询出 数据 做数据更新操作
	 *  false 否则做保存操作
	 * @param id
	 * @return
	 */
	private boolean findPreferential(Integer id) {
		preferential = preferentialDao.findPreferentialById(id);
		if (preferential == null) {
			return false;
		} else {
			return true;
		}
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
	
	public Preferential getPreferential() {
		return preferential;
	}

	public void setPreferential(Preferential preferential) {
		this.preferential = preferential;
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

}
