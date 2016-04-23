package com.ttm.biz.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.apache.log4j.Logger;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.ttm.biz.MeiShiBiz;
import com.ttm.dao.MeiShiDao;
import com.ttm.dao.impl.MeiShiDaoImpl;
import com.ttm.orm.MeiShi;
import com.ttm.util.Page;
import com.ttm.util.PageUtil;
import com.ttm.util.ServicePaginationHelper;
import com.ttm.util.ServiceQueryHelper;
import com.ttm.util.ServiceSorterHelper;
import com.ttm.util.UploadImgUtil;

public class MeiShiBizImpl implements MeiShiBiz {

	public static final Logger log = Logger.getLogger(MeiShiBizImpl.class);

	private MeiShiDao meiShiDao = new MeiShiDaoImpl();

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
	
	private String imgPath = "";
	
	private boolean isUpload = true;

	public List<MeiShi> findMeiShiList(Integer page, Integer size, Integer type, String sortName) {
		Map<String, Integer> pageing = ServicePaginationHelper.build(size, page);
		Map<String, Object> sort = ServiceSorterHelper.build(sortName, ServiceSorterHelper.ASC);
		Map<String, Object> query = new HashMap<String, Object>();
		ServiceQueryHelper.and(query, "type", type);
		
		List<MeiShi> meiShisList = meiShiDao.findMeiShiByList(query, sort, pageing);
		if (CollectionUtils.isNotEmpty(meiShisList)) {
			this.pageNumber = page;
			this.size = size;
			this.totalNumber = countReptileNumber(query);
		} else {
			log.warn("美食数据查询为空...");
		}
		PageUtil pageUtil = PageUtil.getPageUtil();
		this.page = pageUtil.createPage(pageNumber, this.size, totalNumber, pageRange);
		countShowPage(this.page.getRangeStart(), this.page.getRangeEnd());
		return meiShisList;
	}

	public boolean saveMeiShi(String url, String title, Integer mark, String img, Integer creator, String creatorDate) {
		MeiShi meiShi = setMeiShi(url, title, mark, img, creator, creatorDate);
		return meiShiDao.addMeiShi(meiShi);
	}
	
	public MeiShi findMeiShi(Integer id) {
		return meiShiDao.findMeiShiById(id);
	}

	public boolean deleteMeiShi(Integer id) {
		MeiShi meiShi = findMeiShi(id);
		if (meiShi != null) {
			return meiShiDao.deleteMeiShi(meiShi);
		}
		return false;
	}

	private MeiShi setMeiShi(String url, String title, Integer mark, String img, Integer creator, String creatorDate) {
		MeiShi meishi = new MeiShi();
		meishi.setUrl(url);
		meishi.setTitle(title);
		meishi.setMark(mark);
		meishi.setImg(img);
		meishi.setCreatdId(creator);
		meishi.setCreatdDate(creatorDate);
		// 2，代表美食
		meishi.setType(2);
		return meishi;
	}

	/**
	 * 计算总数量
	 * 
	 * @return
	 */
	public Integer countReptileNumber(Map<String, Object> query) {
		List<MeiShi> reptilesList = meiShiDao.findMeiShiByList(query, null, null);
		if (CollectionUtils.isNotEmpty(reptilesList)) {
			return reptilesList.size();
		}
		return 1;
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

	public void uploadImg(MultipartHttpServletRequest multiRequest) {
		UploadImgUtil upload = new UploadImgUtil();
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
