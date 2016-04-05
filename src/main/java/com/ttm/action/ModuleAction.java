package com.ttm.action;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ModelAndView;

import com.ttm.biz.PreferentialBiz;
import com.ttm.biz.SafetyBiz;
import com.ttm.biz.StoreBiz;
import com.ttm.biz.impl.PreferentialBizImpl;
import com.ttm.biz.impl.SafetyBizImpl;
import com.ttm.biz.impl.StoreBizImpl;
import com.ttm.orm.Preferential;
import com.ttm.orm.Safety;
import com.ttm.orm.Store;
import com.ttm.util.Dumper;
import com.ttm.util.ServiceSorterHelper;

/**
 * 
 * <p>
 * 介绍:优惠模块 action
 * </p>
 * 
 * @author 唐太明
 * @date 2016年4月3日 上午12:24:26
 * @version 1.0
 */
@Controller
public class ModuleAction {

	private ModelAndView view = new ModelAndView();

	private PreferentialBiz preferentialBiz = new PreferentialBizImpl();

	private StoreBiz storeBiz = new StoreBizImpl();
	
	private SafetyBiz safetyBiz = new SafetyBizImpl();

	/**
	 * 新增安全食物 - 图片上传
	 * 
	 * @param type
	 * @return
	 * @throws MalformedURLException
	 */
	@RequestMapping(value = "safety", method = RequestMethod.POST)
	public String safety(HttpServletRequest request) throws MalformedURLException {
		System.out.println("url：" + request.getParameter("url"));
		System.out.println("title：" + request.getParameter("title"));
		System.out.println("mark：" + request.getParameter("mark"));
		String url = request.getParameter("url");
		String title = request.getParameter("title");
		String mark = request.getParameter("mark");
		String img = "";

		// 开始时间
		long startTime = System.currentTimeMillis();

		MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
		Iterator<String> iterator = multiRequest.getFileNames();
		boolean isUpload = true;
		while (iterator.hasNext()) {
			// 遍历所有文件
			MultipartFile file = multiRequest.getFile(iterator.next().toString());
			if (file != null) {
				SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
				String datePath = format.format(new Date());
				String jpgPath = datePath + "_" + file.getOriginalFilename();
				//获取文件名称
				img = jpgPath;
				System.out.println(
						"^^^^^^^^^^^^^^^^^^^^^^^^^^^^" + request.getSession().getServletContext().getRealPath("/"));
				String path = request.getSession().getServletContext().getRealPath("/") + "\\images\\upload\\"
						+ jpgPath;
				path = "E:\\Project\\learngit\\SimplePoint\\src\\main\\webapp\\images\\upload\\" + jpgPath;
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

		// 保存数据 并且上传图片
		// url， title， mark，img名称 ，创建人，创建时间
		// 错误重新进入新增页面
		if (!isUpload) {
			return "redirect:/safety?type=s";
		}
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		safetyBiz.saveSafety(url, title, Integer.valueOf(mark), img, 1, format.format(new Date()));
		return "redirect:/safety?page=1&size=25";
	}

	/**
	 * 进入安全食物新增页面
	 * 
	 * @param type
	 * @return
	 */
	@RequestMapping(value = "safety", params = "type", method = RequestMethod.GET)
	public String safety(@RequestParam(value = "type") String type) {
		// s 代表保存
		if (StringUtils.equals(type, "s")) {
			return "/competence/add-safety";
		}
		return "/index";
	}

	/**
	 * 首页安全食物模块列表
	 * 
	 * @param page
	 * @param size
	 * @param sea
	 * @param sort
	 * @return
	 */
	@RequestMapping(value = "safety", params = { "page", "size" }, method = RequestMethod.GET)
	public ModelAndView safety(@RequestParam(value = "page") int page, @RequestParam(value = "size") int size,
			@RequestParam(value = "sea", required = false) String sea,
			@RequestParam(value = "sort", required = false) String sort) {
		// 安全模块 默认第一页 (page)，查询数量 (size)，类型是安全 (type)，根据mark排序 升序排序 (mark)
		// 1 代表 安全模块
		Integer type = 1;
		// 默认排序 mark
		String defaultSort = "mark";
		List<Safety> safetysList = safetyBiz.findSafetyList(page, size, type, defaultSort);
		view.addObject("safetysList", safetysList);
		view.addObject("page", ((SafetyBizImpl) safetyBiz).getPage());
		view.addObject("showPage", ((SafetyBizImpl) safetyBiz).getShowPage());
		view.setViewName("/competence/safety");
		return view;
	}

	/**
	 * 首页学校店铺模块列表 按销量排序
	 * 
	 * @param page
	 * @param size
	 * @param sea
	 * @param sort
	 * @return
	 */
	@RequestMapping(value = "school_module", params = { "page", "size" }, method = RequestMethod.GET)
	public ModelAndView schoolModule(@RequestParam(value = "page") int page, @RequestParam(value = "size") int size,
			@RequestParam(value = "sea", required = false) String sea,
			@RequestParam(value = "sort", required = false) String sort) {
		List<Store> storesList = storeBiz.findStoreList(page, size);
		view.addObject("storesList", storesList);
		view.addObject("page", ((StoreBizImpl) storeBiz).getPage());
		view.addObject("showPage", ((StoreBizImpl) storeBiz).getShowPage());
		view.setViewName("/competence/store-module");
		return view;
	}

	/**
	 * 优惠模块列表
	 * 
	 * @param page
	 * @param size
	 * @param sea
	 * @param sort
	 * @return
	 */
	@RequestMapping(value = "preferential", params = { "page", "size" }, method = RequestMethod.GET)
	public ModelAndView preferential(@RequestParam(value = "page") int page, @RequestParam(value = "size") int size,
			@RequestParam(value = "sea", required = false) String sea,
			@RequestParam(value = "sort", required = false) String sort) {
		List<Preferential> preferentialsList = preferentialBiz.findPreferentialList(page, size);
		view.addObject("preferentialsList", preferentialsList);
		view.addObject("page", ((PreferentialBizImpl) preferentialBiz).getPage());
		view.addObject("showPage", ((PreferentialBizImpl) preferentialBiz).getShowPage());
		view.setViewName("/competence/preferential");
		return view;
	}

	/**
	 * 进入优惠编辑模块
	 * 
	 * @return
	 */
	@RequestMapping(value = "preferential", method = RequestMethod.GET)
	public ModelAndView preferential() {
		List<Preferential> preferentialsList = preferentialBiz.findPreferentialList("id", ServiceSorterHelper.ASC);
		view.addObject("numberList21", ((PreferentialBizImpl) preferentialBiz).fetch21());
		view.addObject("preferentialsList", preferentialsList);
		view.setViewName("/competence/edit-preferential");
		Dumper.dump(preferentialsList);
		return view;
	}

	/**
	 * 保存优惠编辑
	 * 
	 * @param requestJson
	 * @return
	 */
	@RequestMapping(value = "preferential", method = RequestMethod.POST)
	public String preferential(HttpServletRequest request) {
		System.out.println(request.getParameter("requestJson"));
		String requestJson = request.getParameter("requestJson");
		Map<String, Object> requestData = preferentialBiz.parseRequestParams(requestJson);
		preferentialBiz.saveOrUpdatePreferential(requestData);
		return "redirect:/preferential?page=1&size=10";
	}

	@RequestMapping(value = "preferential", params = "type", method = RequestMethod.GET)
	public String indexUpdate(@RequestParam(value = "type") String type) {
		preferentialBiz.updateIndex();
		return "/";
	}

}
