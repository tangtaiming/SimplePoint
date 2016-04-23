package com.ttm.biz.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.apache.log4j.Logger;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.ttm.biz.SafetyBiz;
import com.ttm.dao.SafetyDao;
import com.ttm.dao.impl.SafetyDaoImpl;
import com.ttm.orm.Reptile;
import com.ttm.orm.Safety;
import com.ttm.util.Page;
import com.ttm.util.PageUtil;
import com.ttm.util.ServicePaginationHelper;
import com.ttm.util.ServiceQueryHelper;
import com.ttm.util.ServiceSorterHelper;
import com.ttm.util.UploadImgUtil;

public class SafetyBizImpl implements SafetyBiz	 {
	
	public static final Logger log = Logger.getLogger(SafetyBizImpl.class);
	
	private SafetyDao safetyDao = new SafetyDaoImpl();

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
	
	private UploadImgUtil upload = new UploadImgUtil();
	
	private String imgPath;
	
	private boolean isUpload;
	
	public List<Safety> findSafetyList(Integer page, Integer size, Integer type, String sortName) {
		Map<String, Integer> pageing = ServicePaginationHelper.build(size, page);
		Map<String, Object> sort = ServiceSorterHelper.build(sortName, ServiceSorterHelper.ASC);
		Map<String, Object> query = new HashMap<String, Object>();
		ServiceQueryHelper.and(query, "type", type);
		List<Safety> safetysList = safetyDao.findSafetyByList(query, sort, pageing);
		if (CollectionUtils.isNotEmpty(safetysList)) {
			this.totalNumber = countReptileNumber(query);
			pageNumber = page;
			this.size = size;
		} else {
			log.warn("查询数据为空...");
		}
		PageUtil pageUtil = PageUtil.getPageUtil();
		this.page = pageUtil.createPage(pageNumber, this.size, totalNumber, pageRange);
		countShowPage(this.page.getRangeStart(), this.page.getRangeEnd());
		return safetysList;
	}

	public boolean saveSafety(String url, String title, Integer mark, String img, Integer creator, String creatorDate) {
		Safety safety = setSafety(url, title, mark, img, creator, creatorDate);
		return safetyDao.addSafety(safety);
	}
	
	public Safety findSafety(Integer id) {
		return safetyDao.findSafetyById(id);
	}

	public boolean deleteSafety(Integer id) {
		Safety safety = findSafety(id);
		if (safety == null) {
			log.warn("查询食品安全数据为空，无法进行删除操作");
			return false;
		} else {
			safetyDao.deleteSafety(safety);
			return true;
		}
	}

	private Safety setSafety(String url, String title, Integer mark, String img, Integer creator, String creatorDate) {
		Safety safety = new Safety();
		safety.setUrl(url);
		safety.setTitle(title);
		safety.setMark(mark);
		safety.setImg(img);
		safety.setCreatdId(creator);
		safety.setCreatdDate(creatorDate);
		//1，代表安全模块
		safety.setType(1);
		return safety;
	}
	
	/**
	 * 计算总数量
	 * @return
	 */
	public Integer countReptileNumber(Map<String, Object> query) {
		List<Safety> reptilesList = safetyDao.findSafetyByList(query, null, null);
		if (CollectionUtils.isNotEmpty(reptilesList)) {
			return reptilesList.size();
		}
		return 1;
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
	
	/**
	 * 上传图片
	 * @param multiRequest
	 */
	public void uploadImg(MultipartHttpServletRequest multiRequest) {
		upload.uploadImg(multiRequest);
		imgPath = upload.getPathImg();
		isUpload = upload.isImg();
		log.info("isUpload:" + isUpload);
		log.info("imgPath:" + imgPath);
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

	public String getImgPath() {
		return imgPath;
	}

	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}

	public boolean isUpload() {
		return isUpload;
	}

	public void setUpload(boolean isUpload) {
		this.isUpload = isUpload;
	}

}
