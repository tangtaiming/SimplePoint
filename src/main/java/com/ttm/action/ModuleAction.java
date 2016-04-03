package com.ttm.action;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ttm.biz.PreferentialBiz;
import com.ttm.biz.StoreBiz;
import com.ttm.biz.impl.PreferentialBizImpl;
import com.ttm.biz.impl.StoreBizImpl;
import com.ttm.orm.Preferential;
import com.ttm.orm.Store;
import com.ttm.util.Dumper;
import com.ttm.util.ServiceSorterHelper;
/**
 * 
 * <p>介绍:优惠模块 action</p>
 * @author 唐太明
 * @date 2016年4月3日 上午12:24:26
 * @version 1.0
 */
@Controller
public class ModuleAction {

	private ModelAndView view = new ModelAndView();
	
	private PreferentialBiz preferentialBiz = new PreferentialBizImpl();
	
	private StoreBiz storeBiz = new StoreBizImpl();
	
	/**
	 * 首页学校模块列表
	 * @param page
	 * @param size
	 * @param sea
	 * @param sort
	 * @return
	 */
	@RequestMapping(value = "preferential", params = { "page", "size" }, method = RequestMethod.GET)
	public ModelAndView school(@RequestParam(value = "page") int page, @RequestParam(value = "size") int size,
			@RequestParam(value = "sea", required = false) String sea, @RequestParam(value = "sort", required = false) String sort) {
		List<Store> storesList = storeBiz.findStoreList(page, size);
		view.addObject("storesList", storesList);
		view.addObject("page", ((StoreBizImpl) storesList).getPage());
		view.addObject("showPage", ((StoreBizImpl) storesList).getShowPage());
		return view;
	}
	
	/**
	 * 优惠模块列表
	 * @param page
	 * @param size
	 * @param sea
	 * @param sort
	 * @return
	 */
	@RequestMapping(value = "preferential", params = { "page", "size" }, method = RequestMethod.GET)
	public ModelAndView preferential(@RequestParam(value = "page") int page, @RequestParam(value = "size") int size,
			@RequestParam(value = "sea", required = false) String sea, @RequestParam(value = "sort", required = false) String sort) {
		List<Preferential> preferentialsList = preferentialBiz.findPreferentialList(page, size);
		view.addObject("preferentialsList", preferentialsList);
		view.addObject("page", ((PreferentialBizImpl) preferentialBiz).getPage());
		view.addObject("showPage", ((PreferentialBizImpl) preferentialBiz).getShowPage());
		view.setViewName("/competence/preferential");
		return view;
	}
	
	/**
	 * 进入优惠编辑模块
	 * @return
	 */
	@RequestMapping(value = "preferential", method = RequestMethod.GET)
	public ModelAndView  preferential() {
		List<Preferential> preferentialsList = preferentialBiz.findPreferentialList("id", ServiceSorterHelper.ASC);
		view.addObject("numberList21", ((PreferentialBizImpl) preferentialBiz).fetch21());
		view.addObject("preferentialsList", preferentialsList);
		view.setViewName("/competence/edit-preferential");
		Dumper.dump(preferentialsList);
		return view;
	}
	
	/**
	 * 保存优惠编辑
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
