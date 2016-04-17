package com.ttm.action;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.ttm.biz.MeiShiBiz;
import com.ttm.biz.MeiShiJiaBiz;
import com.ttm.biz.PreferentialBiz;
import com.ttm.biz.SafetyBiz;
import com.ttm.biz.ShiPinBiz;
import com.ttm.biz.ShuiGuoBiz;
import com.ttm.biz.StoreBiz;
import com.ttm.biz.impl.MeiShiBizImpl;
import com.ttm.biz.impl.MeiShiJiaBizImpl;
import com.ttm.biz.impl.PreferentialBizImpl;
import com.ttm.biz.impl.SafetyBizImpl;
import com.ttm.biz.impl.ShiPinBizImpl;
import com.ttm.biz.impl.ShuiGuoBizImpl;
import com.ttm.biz.impl.StoreBizImpl;
import com.ttm.orm.MeiShi;
import com.ttm.orm.MeiShiJia;
import com.ttm.orm.Preferential;
import com.ttm.orm.Safety;
import com.ttm.orm.ShiPin;
import com.ttm.orm.ShuiGuo;
import com.ttm.orm.Store;
import com.ttm.util.Dumper;
import com.ttm.util.ServiceSorterHelper;

/**
 * 
 * <p>
 * 介绍:模块 action
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

	private MeiShiBiz meiShiBiz = new MeiShiBizImpl();

	private ShiPinBiz shiPinBiz = new ShiPinBizImpl();

	private MeiShiJiaBiz meiShiJiaBiz = new MeiShiJiaBizImpl();

	private ShuiGuoBiz shuiGuoBiz = new ShuiGuoBizImpl();

	/**
	 * 保存水果数据/并且上传图片
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "shuiguo", method = RequestMethod.POST)
	public String shuiGuo(HttpServletRequest request) {
		System.out.println("url：" + request.getParameter("url"));
		System.out.println("title：" + request.getParameter("title"));
		System.out.println("mark：" + request.getParameter("mark"));
		String url = request.getParameter("url");
		String title = request.getParameter("title");
		String mark = request.getParameter("mark");

		// 上传图片
		((ShuiGuoBizImpl) shuiGuoBiz).uploadImg((MultipartHttpServletRequest) request);
		if (!((ShuiGuoBizImpl) shuiGuoBiz).isUpload()) {
			return "/competence/shuiguo?type=s";
		}
		String img = ((ShuiGuoBizImpl) shuiGuoBiz).getImgPath();

		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		shuiGuoBiz.saveShuiGuo(url, title, Integer.valueOf(mark), img, 1, format.format(new Date()));
		return "redirect:/shuiguo?page=1&size=25";
	}
	
	/**
	 * 进入水果新增页面
	 * @param type
	 * @return
	 */
	@RequestMapping(value = "shuiguo", method = RequestMethod.GET)
	public String shuiGuo(@RequestParam(value = "type") String type) {
		// s 代表保存
		if (type.equals("s")) {
			return "/competence/add-shuiguo";
		}
		return "/index";
	}

	/**
	 * 水果模块列表
	 * 
	 * @param page
	 * @param size
	 * @param sea
	 * @param sort
	 * @return
	 */
	@RequestMapping(value = "shuiguo", params = { "page", "size" }, method = RequestMethod.GET)
	public ModelAndView shuiGuo(@RequestParam(value = "page") int page, @RequestParam(value = "size") int size,
			@RequestParam(value = "sea", required = false) String sea,
			@RequestParam(value = "sort", required = false) String sort) {
		// 水果家默认第一页 (page)，查询数量 (size)，类型是水果(type)，根据mark排序 升序排序 (mark)
		// 5 代表 视水果
		Integer type = 5;
		// 默认排序 mark
		String defaultSort = "mark";

		List<ShuiGuo> shuiGuosList = shuiGuoBiz.findShuiGuoList(page, size, type, defaultSort);
		view.addObject("shuiGuosList", shuiGuosList);
		view.addObject("page", ((ShuiGuoBizImpl) shuiGuoBiz).getPage());
		view.addObject("showPage", ((ShuiGuoBizImpl) shuiGuoBiz).getShowPage());
		view.setViewName("/competence/shuiguo");
		return view;
	}

	/**
	 * 保存美食家数据/并且上传照片
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "meishijia", method = RequestMethod.POST)
	public String meiShiJia(HttpServletRequest request) {
		System.out.println("url：" + request.getParameter("url"));
		System.out.println("title：" + request.getParameter("title"));
		System.out.println("mark：" + request.getParameter("mark"));
		String url = request.getParameter("url");
		String title = request.getParameter("title");
		String mark = request.getParameter("mark");

		// 上传图片
		((MeiShiJiaBizImpl) meiShiJiaBiz).uploadImg((MultipartHttpServletRequest) request);
		if (!((MeiShiJiaBizImpl) meiShiJiaBiz).isUpload()) {
			return "/competence/meishijia?type=s";
		}
		String img = ((MeiShiJiaBizImpl) meiShiJiaBiz).getImgPath();

		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		meiShiJiaBiz.saveMeiShiJia(url, title, Integer.valueOf(mark), img, 1, format.format(new Date()));
		return "redirect:/meishijia?page=1&size=25";
	}

	/**
	 * 进入美食家新增页面
	 * 
	 * @param type
	 * @return
	 */
	@RequestMapping(value = "meishijia", method = RequestMethod.GET)
	public String meiShiJia(@RequestParam(value = "type") String type) {
		// s 代表保存
		if (type.equals("s")) {
			return "/competence/add-meishijia";
		}
		return "/index";
	}

	/**
	 * 美食家模块
	 * 
	 * @param page
	 * @param size
	 * @param sea
	 * @param sort
	 * @return
	 */
	@RequestMapping(value = "meishijia", params = { "page", "size" }, method = RequestMethod.GET)
	public ModelAndView meiShiJia(@RequestParam(value = "page") int page, @RequestParam(value = "size") int size,
			@RequestParam(value = "sea", required = false) String sea,
			@RequestParam(value = "sort", required = false) String sort) {
		// 美食家默认第一页 (page)，查询数量 (size)，类型是美食家(type)，根据mark排序 升序排序 (mark)
		// 4 代表 视美食家
		Integer type = 4;
		// 默认排序 mark
		String defaultSort = "mark";

		List<MeiShiJia> meisShiJiasList = meiShiJiaBiz.findMeiShiJiaList(page, size, type, defaultSort);
		view.addObject("meisShiJiasList", meisShiJiasList);
		view.addObject("page", ((MeiShiJiaBizImpl) meiShiJiaBiz).getPage());
		view.addObject("showPage", ((MeiShiJiaBizImpl) meiShiJiaBiz).getShowPage());
		view.setViewName("/competence/meishijia");
		return view;
	}

	/**
	 * 视频数据保存 /并且上传图片
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "shipin", method = RequestMethod.POST)
	public String shiPin(HttpServletRequest request) {
		System.out.println("url：" + request.getParameter("url"));
		System.out.println("title：" + request.getParameter("title"));
		System.out.println("mark：" + request.getParameter("mark"));
		String url = request.getParameter("url");
		String title = request.getParameter("title");
		String mark = request.getParameter("mark");

		// 上传图片
		((ShiPinBizImpl) shiPinBiz).uploadImg((MultipartHttpServletRequest) request);
		if (!((ShiPinBizImpl) shiPinBiz).isUpload()) {
			return "/competence/shipin?type=s";
		}
		String img = ((ShiPinBizImpl) shiPinBiz).getImgPath();

		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		shiPinBiz.saveShiPin(url, title, Integer.valueOf(mark), img, 1, format.format(new Date()));
		return "redirect:/shipin?page=1&size=25";
	}

	/**
	 * 进入视频新增页面
	 * 
	 * @param type
	 * @return
	 */
	@RequestMapping(value = "shipin", method = RequestMethod.GET)
	public String shiPin(@RequestParam(value = "type") String type) {
		// s 代表保存
		if (type.equals("s")) {
			return "/competence/add-shipin";
		}
		return "/index";
	}

	/**
	 * 视频模块
	 * 
	 * @param page
	 * @param size
	 * @param sea
	 * @param sort
	 * @return
	 */
	@RequestMapping(value = "shipin", params = { "page", "size" }, method = RequestMethod.GET)
	public ModelAndView shiPin(@RequestParam(value = "page") int page, @RequestParam(value = "size") int size,
			@RequestParam(value = "sea", required = false) String sea,
			@RequestParam(value = "sort", required = false) String sort) {
		// 视频默认第一页 (page)，查询数量 (size)，类型是视频(type)，根据mark排序 升序排序 (mark)
		// 3 代表 视频
		Integer type = 3;
		// 默认排序 mark
		String defaultSort = "mark";

		List<ShiPin> shiPinsList = shiPinBiz.findShiPinList(page, size, type, defaultSort);
		view.addObject("shiPinsList", shiPinsList);
		view.addObject("page", ((ShiPinBizImpl) shiPinBiz).getPage());
		view.addObject("showPage", ((ShiPinBizImpl) shiPinBiz).getShowPage());
		view.setViewName("/competence/shipin");
		return view;
	}

	/**
	 * 美食模块
	 * 
	 * @param page
	 * @param size
	 * @param sea
	 * @param sort
	 * @return
	 */
	@RequestMapping(value = "meishi", params = { "page", "size" }, method = RequestMethod.GET)
	public ModelAndView meiShi(@RequestParam(value = "page") int page, @RequestParam(value = "size") int size,
			@RequestParam(value = "sea", required = false) String sea,
			@RequestParam(value = "sort", required = false) String sort) {
		// 美食默认第一页 (page)，查询数量 (size)，类型是美食 (type)，根据mark排序 升序排序 (mark)
		// 2 代表 美食
		Integer type = 2;
		// 默认排序 mark
		String defaultSort = "mark";

		List<MeiShi> meiShisList = meiShiBiz.findMeiShiList(page, size, type, defaultSort);
		view.addObject("meiShisList", meiShisList);
		view.addObject("page", ((MeiShiBizImpl) meiShiBiz).getPage());
		view.addObject("showPage", ((MeiShiBizImpl) meiShiBiz).getShowPage());
		view.setViewName("/competence/meishi");
		return view;
	}

	/**
	 * 进入美食新增页面
	 * 
	 * @param type
	 * @return
	 */
	@RequestMapping(value = "meishi", method = RequestMethod.GET)
	public String meiShi(@RequestParam(value = "type") String type) {
		// s 代表保存
		if (type.equals("s")) {
			return "/competence/add-meishi";
		}
		return "/index";
	}

	/**
	 * 美食数据保存 /并且上传图片
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "meishi", method = RequestMethod.POST)
	public String meiShi(HttpServletRequest request) {
		System.out.println("url：" + request.getParameter("url"));
		System.out.println("title：" + request.getParameter("title"));
		System.out.println("mark：" + request.getParameter("mark"));
		String url = request.getParameter("url");
		String title = request.getParameter("title");
		String mark = request.getParameter("mark");

		// 上传图片
		((MeiShiBizImpl) meiShiBiz).uploadImg((MultipartHttpServletRequest) request);
		if (!((MeiShiBizImpl) meiShiBiz).isUpload()) {
			return "/competence/meishi?type=s";
		}
		String img = ((MeiShiBizImpl) meiShiBiz).getImgPath();

		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		meiShiBiz.saveMeiShi(url, title, Integer.valueOf(mark), img, 1, format.format(new Date()));
		return "redirect:/meishi?page=1&size=25";
	}

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
				// 获取文件名称
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
