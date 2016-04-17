package com.ttm.biz.impl;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.apache.log4j.Logger;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.ttm.biz.ShiPinBiz;
import com.ttm.dao.ShiPinDao;
import com.ttm.dao.impl.ShiPinDaoImpl;
import com.ttm.orm.MeiShi;
import com.ttm.orm.ShiPin;
import com.ttm.util.Page;
import com.ttm.util.PageUtil;
import com.ttm.util.ServicePaginationHelper;
import com.ttm.util.ServiceQueryHelper;
import com.ttm.util.ServiceSorterHelper;

public class ShiPinBizImpl implements ShiPinBiz {

	public static final Logger log = Logger.getLogger(ShiPinBizImpl.class);
	
	private ShiPinDao shiPinDao = new ShiPinDaoImpl();

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
	
	public List<ShiPin> findShiPinList(Integer page, Integer size, Integer type, String sortName) {
		Map<String, Object> query = new HashMap<String, Object>();
		ServiceQueryHelper.and(query, "type", type);
		Map<String, Integer> pageing = ServicePaginationHelper.build(size, page);
		Map<String, Object> sort = ServiceSorterHelper.build(sortName, ServiceSorterHelper.ASC);
		
		List<ShiPin> shiPinList = shiPinDao.findShiPinByList(query, sort, pageing);
		if (CollectionUtils.isNotEmpty(shiPinList)) {
			this.totalNumber = countReptileNumber(query);
			this.pageNumber = page;
			this.size = size;
		} else {
			log.warn("查询视频数据为空.");
		}
		PageUtil pageUtil = PageUtil.getPageUtil();
		this.page = pageUtil.createPage(pageNumber, this.size, totalNumber, pageRange);
		countShowPage(this.page.getRangeStart(), this.page.getRangeEnd());
		return shiPinList;
	}

	public boolean saveShiPin(String url, String title, Integer mark, String img, Integer creator, String creatorDate) {
		ShiPin shiPin = setShiPin(url, title, mark, img, creator, creatorDate);
		return shiPinDao.addShiPin(shiPin);
	}
	
	private ShiPin setShiPin(String url, String title, Integer mark, String img, Integer creator, String creatorDate) {
		ShiPin shiPin = new ShiPin();
		shiPin.setUrl(url);
		shiPin.setTitle(title);
		shiPin.setMark(mark);
		shiPin.setImg(img);
		shiPin.setCreatdId(creator);
		shiPin.setCreatdDate(creatorDate);
		// 3，代表视屏
		shiPin.setType(3);
		return shiPin;
	}

	/**
	 * 计算总数量
	 * 
	 * @return
	 */
	public Integer countReptileNumber(Map<String, Object> query) {
		List<ShiPin> reptilesList = shiPinDao.findShiPinByList(query, null, null);
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
		// 开始时间
		long startTime = System.currentTimeMillis();
		Iterator<String> iterator = multiRequest.getFileNames();
		while (iterator.hasNext()) {
			// 遍历所有文件
			MultipartFile file = multiRequest.getFile(iterator.next().toString());
			if (file != null) {
				SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
				String datePath = format.format(new Date());
				String jpgPath = datePath + "_" + file.getOriginalFilename();
				// 获取文件名称
				imgPath = jpgPath;
				System.out.println(
						"^^^^^^^^^^^^^^^^^^^^^^^^^^^^" + multiRequest.getServletContext().getRealPath("/"));
//				String path = request.getSession().getServletContext().getRealPath("/") + "\\images\\upload\\"
//						+ jpgPath;
				String path = "E:\\Project\\learngit\\SimplePoint\\src\\main\\webapp\\images\\upload\\" + jpgPath;
				// 上传
				try {
					file.transferTo(new File(path));
				} catch (IllegalStateException e) {
					e.printStackTrace();
					isUpload = false;
				} catch (IOException e) {
					e.printStackTrace();
					isUpload = false;
				}
			}
		}
		// 结束时间
		long endTime = System.currentTimeMillis();
		System.out.println("运行时间:" + String.valueOf(endTime - startTime));
	}

	public List<Integer> getShowPage() {
		return showPage;
	}

	public void setShowPage(List<Integer> showPage) {
		this.showPage = showPage;
	}

	public int getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
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

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

}