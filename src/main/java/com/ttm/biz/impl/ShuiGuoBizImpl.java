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

import com.ttm.biz.ShuiGuoBiz;
import com.ttm.dao.ShuiGuoDao;
import com.ttm.dao.impl.ShuiGuoDaoImpl;
import com.ttm.orm.ShuiGuo;
import com.ttm.util.Page;
import com.ttm.util.PageUtil;
import com.ttm.util.ServicePaginationHelper;
import com.ttm.util.ServiceQueryHelper;
import com.ttm.util.ServiceSorterHelper;

/**
 * 
 * <p>
 * 介绍:水果业务逻辑层实现类
 * </p>
 * 
 * @author 唐太明
 * @date 2016年4月17日 下午3:07:08
 * @version 1.0
 */
public class ShuiGuoBizImpl implements ShuiGuoBiz {

	public static final Logger log = Logger.getLogger(ShuiGuoBizImpl.class);

	private ShuiGuoDao shuiGuoDao = new ShuiGuoDaoImpl();

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
	
	public List<ShuiGuo> findShuiGuoList(Integer page, Integer size, Integer type, String sortName) {
		Map<String, Object> query = new HashMap<String, Object>();
		ServiceQueryHelper.and(query, "type", type);
		Map<String, Integer> pageing = ServicePaginationHelper.build(size, page);
		Map<String, Object> sort = ServiceSorterHelper.build(sortName, ServiceSorterHelper.ASC);
		
		List<ShuiGuo> shuiGuosList = shuiGuoDao.findShuiGuoByList(query, sort, pageing);
		if (CollectionUtils.isNotEmpty(shuiGuosList)) {
			this.totalNumber = countReptileNumber(query);
			this.pageNumber = page;
			this.size = size;
		} else {
			log.info("查询水果数据为空.");
		}
		PageUtil pageUtil = PageUtil.getPageUtil();
		this.page = pageUtil.createPage(pageNumber, this.size, totalNumber, pageRange);
		countShowPage(this.page.getRangeStart(), this.page.getRangeEnd());
		return shuiGuosList;
	}

	public boolean saveShuiGuo(String url, String title, Integer mark, String img, Integer creator,
			String creatorDate) {
		ShuiGuo shuiGuo = setShuiGuo(url, title, mark, img, creator, creatorDate);
		return shuiGuoDao.addShuiGuo(shuiGuo);
	}
	
	private ShuiGuo setShuiGuo(String url, String title, Integer mark, String img, Integer creator, String creatorDate) {
		ShuiGuo shuiGuo = new ShuiGuo();
		shuiGuo.setUrl(url);
		shuiGuo.setTitle(title);
		shuiGuo.setMark(mark);
		shuiGuo.setImg(img);
		shuiGuo.setCreatdId(creator);
		shuiGuo.setCreatdDate(creatorDate);
		// 5，代表水果
		shuiGuo.setType(5);
		return shuiGuo;
	}

	/**
	 * 计算总数量
	 * 
	 * @return
	 */
	public Integer countReptileNumber(Map<String, Object> query) {
		List<ShuiGuo> shuiGuosList = shuiGuoDao.findShuiGuoByList(query, null, null);
		if (CollectionUtils.isNotEmpty(shuiGuosList)) {
			return shuiGuosList.size();
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
