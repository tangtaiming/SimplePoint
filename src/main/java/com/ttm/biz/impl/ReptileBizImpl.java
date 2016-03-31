package com.ttm.biz.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;

import com.ttm.biz.ReptileBiz;
import com.ttm.dao.ReptileDao;
import com.ttm.dao.impl.ReptileDaoImpl;
import com.ttm.orm.Reptile;
import com.ttm.orm.School;
import com.ttm.util.Dumper;
import com.ttm.util.Page;
import com.ttm.util.PageUtil;
import com.ttm.util.ServicePaginationHelper;
import com.ttm.util.ServiceSorterHelper;

public class ReptileBizImpl implements ReptileBiz {
	
	private ReptileDao reptileDao = new ReptileDaoImpl();
	
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

	public boolean deleteReptile(Integer id) {
		Reptile reptile = reptileDao.findReptileById(id);
		if (reptile != null) {
			return reptileDao.deleteReptile(reptile);
		}
		return false;
	}

	public List<Reptile> findReptileList(Integer page, Integer size) {
		Map<String, Integer> pageing = ServicePaginationHelper.build(size, page);
		Map<String, Object> sort = ServiceSorterHelper.build("creatdDate", ServiceSorterHelper.ASC);
		List<Reptile> reptilesList = reptileDao.findReptileByList(null, sort, pageing);
		PageUtil pu = PageUtil.getPageUtil();
		if (CollectionUtils.isNotEmpty(reptilesList)) {
			pageNumber = page;
			this.size = size;
			totalNumber = countReptileNumber();
		}
		this.page = pu.createPage(pageNumber, this.size, totalNumber, pageRange);
		countShowPage(this.page.getRangeStart(), this.page.getRangeEnd());
		return reptilesList;
	}

	public Integer countReptileNumber() {
		List<Reptile> reptilesList = reptileDao.findReptileByList(null, null, null);
		if (CollectionUtils.isNotEmpty(reptilesList)) {
			return reptilesList.size();
		}
		return 1;
	}

	public boolean saveReptile(Reptile reptile, Integer creatdId, String creatDate) {
		reptile.setCreatdId(creatdId);
		reptile.setCreatdDate(creatDate);
		return reptileDao.addReptile(reptile);
	}
	
	public Reptile findReptile(Integer id) {
		Reptile reptile = reptileDao.findReptileById(id);
		return reptile;
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

}
