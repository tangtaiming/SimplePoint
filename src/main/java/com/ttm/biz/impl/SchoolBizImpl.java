package com.ttm.biz.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;

import com.ttm.biz.SchoolBiz;
import com.ttm.dao.SchoolDao;
import com.ttm.dao.impl.SchoolDaoImpl;
import com.ttm.orm.School;
import com.ttm.util.Page;
import com.ttm.util.PageUtil;
import com.ttm.util.ServicePaginationHelper;
import com.ttm.util.ServiceSorterHelper;

public class SchoolBizImpl implements SchoolBiz {

	private SchoolDao schoolDao = new SchoolDaoImpl();

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

	public boolean saveSchool(School school, Integer creatdId, String creatdDate) {
		// 设置值
		school.setCreatdId(creatdId);
		school.setCreatdDate(creatdDate);
		return schoolDao.addSchool(school);
	}

	public List<School> findSchoolList(Integer page, Integer size) {
		Map<String, Integer> pageing = ServicePaginationHelper.build(size, page);
		Map<String, Object> sort = ServiceSorterHelper.build("creatdDate", ServiceSorterHelper.ASC);
		List<School> schoolsList = schoolDao.findSchoolByList(null, sort, pageing);
		PageUtil pu = PageUtil.getPageUtil();
		if (CollectionUtils.isNotEmpty(schoolsList)) {
			pageNumber = page;
			this.size = size;
			totalNumber = countSchoolNumber();
		}
		this.page = pu.createPage(pageNumber, this.size, totalNumber, pageRange);
		countShowPage(this.page.getRangeStart(), this.page.getRangeEnd());
		return schoolsList;
	}

	public boolean deleteSchool(Integer id) {
		School school = schoolDao.findSchoolById(id);
		if (school != null) {
			return schoolDao.deleteSchool(school);
		};
		return false;
	}

	public Integer countSchoolNumber() {
		List<School> schoolsList = schoolDao.findSchoolByList(null, null, null);
		if (CollectionUtils.isNotEmpty(schoolsList)) {
			return schoolsList.size();
		}
		return 1;
	}
	
	public School findSchoolById(Integer id) {
		return schoolDao.findSchoolById(id);
	}
	
	/**
	 * 根据对象对应字段查询数据
	 * @param String sortName
	 * @param String sortValue
	 */
	public List<School> findSchoolList(String sortName, String sortValue) {
		Map<String, Object> sort = ServiceSorterHelper.build(sortName, sortValue);
		List<School> schoolsList = schoolDao.findSchoolByList(null, sort, null);
		if (CollectionUtils.isNotEmpty(schoolsList)) {
			return schoolsList;
		}
		return new ArrayList<School>();
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
