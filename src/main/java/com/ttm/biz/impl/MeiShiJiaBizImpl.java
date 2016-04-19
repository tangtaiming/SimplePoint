package com.ttm.biz.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.apache.log4j.Logger;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.ttm.biz.MeiShiJiaBiz;
import com.ttm.dao.MeiShiJiaDao;
import com.ttm.dao.impl.MeiShiJiaDaoImpl;
import com.ttm.orm.MeiShiJia;
import com.ttm.util.Page;
import com.ttm.util.PageUtil;
import com.ttm.util.ServicePaginationHelper;
import com.ttm.util.ServiceQueryHelper;
import com.ttm.util.ServiceSorterHelper;
import com.ttm.util.UploadImgUtil;

/**
 * 
 * <p>
 * 介绍:美食家业务逻辑层 实现类
 * </p>
 * 
 * @author 唐太明
 * @date 2016年4月17日 下午12:37:59
 * @version 1.0
 */
public class MeiShiJiaBizImpl implements MeiShiJiaBiz {

	public static final Logger log = Logger.getLogger(MeiShiJiaBizImpl.class);

	private MeiShiJiaDao meiShiJiaDao = new MeiShiJiaDaoImpl();

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
	
	/**
	 * 文件上传小工具
	 */
	private UploadImgUtil upload = new UploadImgUtil();
	
	public List<MeiShiJia> findMeiShiJiaList(Integer page, Integer size, Integer type, String sortName) {
		Map<String, Object> query = new HashMap<String, Object>();
		ServiceQueryHelper.and(query, "type", type);
		Map<String, Integer> pageing = ServicePaginationHelper.build(size, page);
		Map<String, Object> sort = ServiceSorterHelper.build(sortName, ServiceSorterHelper.ASC);
		
		List<MeiShiJia> meiShiJiasList = meiShiJiaDao.findMeiShiJiaByList(query, sort, pageing);
		if (CollectionUtils.isNotEmpty(meiShiJiasList)) {
			this.totalNumber = countReptileNumber(query);
			this.pageNumber = page;
			this.size = size;
		} else {
			log.info("查询美食家数据为空");
		}
		PageUtil pageUtil = PageUtil.getPageUtil();
		this.page  = pageUtil.createPage(pageNumber, this.size, totalNumber, pageRange);
		countShowPage(this.page.getRangeStart(), this.page.getRangeEnd());
		return meiShiJiasList;
	}

	public boolean saveMeiShiJia(String url, String title, Integer mark, String img, Integer creator,
			String creatorDate) {
		MeiShiJia meiShiJia = setMeiShiJia(url, title, mark, img, creator, creatorDate);
		return meiShiJiaDao.addMeiShiJia(meiShiJia);
	}
	
	private MeiShiJia setMeiShiJia(String url, String title, Integer mark, String img, Integer creator, String creatorDate) {
		MeiShiJia meiShiJia = new MeiShiJia();
		meiShiJia.setUrl(url);
		meiShiJia.setTitle(title);
		meiShiJia.setMark(mark);
		meiShiJia.setImg(img);
		meiShiJia.setCreatdId(creator);
		meiShiJia.setCreatdDate(creatorDate);
		// 4，代表美食家
		meiShiJia.setType(4);
		return meiShiJia;
	}

	/**
	 * 计算总数量
	 * 
	 * @return
	 */
	public Integer countReptileNumber(Map<String, Object> query) {
		List<MeiShiJia> meiShiJiaJiasList = meiShiJiaDao.findMeiShiJiaByList(query, null, null);
		if (CollectionUtils.isNotEmpty(meiShiJiaJiasList)) {
			return meiShiJiaJiasList.size();
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
