package com.ttm.action;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ttm.biz.ReptileBiz;
import com.ttm.biz.SchoolBiz;
import com.ttm.biz.StoreBiz;
import com.ttm.biz.impl.ReptileBizImpl;
import com.ttm.biz.impl.SchoolBizImpl;
import com.ttm.biz.impl.StoreBizImpl;
import com.ttm.orm.Reptile;
import com.ttm.orm.School;
import com.ttm.orm.Store;
import com.ttm.reptile.MeiTuanReptileFactory;
import com.ttm.util.ServiceSorterHelper;

/**
 * 
 * <p>
 * 介绍:URL action
 * </p>
 * 
 * @author 唐太明
 * @date 2016年3月25日 下午8:33:55
 * @version 1.0
 */
@Controller
public class ReptileAction {
	
	private ReptileBiz reptileBiz = new ReptileBizImpl();
	
	private SchoolBiz schoolBiz = new SchoolBizImpl();
	
	private StoreBiz storeBiz = new StoreBizImpl();
	
	private ModelAndView view = new ModelAndView();
	
	/**
	 * 删除学校信息
	 * 
	 * @param id
	 *            学校对应ID
	 * @return
	 */
	@RequestMapping(value = "reptile/{id}", method = RequestMethod.DELETE)
	public String school(@PathVariable(value = "id") Integer id) {
		reptileBiz.deleteReptile(id);
		return "redirect:/reptile?page=1&size=10";
	}

	/**
	 * 爬虫页面
	 * 
	 * @param page
	 * @param size
	 * @return
	 */
	@RequestMapping(value = "reptile", params = { "page", "size" }, method = RequestMethod.GET)
	public ModelAndView reptile(@RequestParam("page") int page, @RequestParam("size") int size,
			@RequestParam(value = "sea", required = false) String sea, @RequestParam(value = "sort", required = false) String sort) {
		List<Reptile> reptilesList = reptileBiz.findReptileList(page, size);
		view.addObject("reptilesList", reptilesList);
		view.addObject("page", ((ReptileBizImpl) reptileBiz).getPage());
		view.addObject("showPage", ((ReptileBizImpl) reptileBiz).getShowPage());
		view.setViewName("competence/reptile");
		return view;
	}

	/**
	 * 进入爬虫新增页面
	 * 
	 * @return
	 */
	@RequestMapping(value = "reptile", method = RequestMethod.GET)
	public ModelAndView reptile() {
		List<School> schoolsList = schoolBiz.findSchoolList("name", ServiceSorterHelper.ASC);
		if (CollectionUtils.isNotEmpty(schoolsList)) {
			view.addObject("schoolsList", schoolsList);
			view.setViewName("competence/add-reptile");
		} else {
			//返回错误页面
			view.setViewName("");
		}
		return view;
	}

	/**
	 * 保存新增加爬虫
	 * 
	 * @param reptile
	 * @return
	 */
	@RequestMapping(value = "reptile", method = RequestMethod.POST)
	public String reptile(Reptile reptile) {
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Integer createdId = 1;
		String createdDate = format.format(new Date());
		if (reptileBiz.saveReptile(reptile, createdId, createdDate)) {
			return "redirect:/reptile?page=1&size=10";
		}
		return "redirect:/reptile";
	}

	/**
	 * 进入开启对应地址爬虫
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "reptile/{id}/start", method = RequestMethod.GET)
	public ModelAndView start(@PathVariable(value = "id") int id) {
		Reptile reptile = reptileBiz.findReptile(id);
		if (reptile == null) {
			return view;
		}
		view.addObject("reptile", reptile);
		view.addObject("reptileStatus", "准备开启");
		view.setViewName("competence/start-reptile");
		return view;
	}

	/**
	 * 开启对应地址爬虫
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "reptile/{id}/start", params = { "type" }, method = RequestMethod.GET)
	public ModelAndView start(@PathVariable(value = "id") int id, @RequestParam(value = "type") String type) {
		Reptile reptile = reptileBiz.findReptile(id);
		if (reptile == null) {
			return view;
		}
		view.addObject("reptile", reptile);
		view.addObject("reptileStatus", "开启结束");
		view.setViewName("competence/start-reptile");
		MeiTuanReptileFactory factory = new MeiTuanReptileFactory();
		List<Store> stores = factory.startMeituan(reptile.getUrl());
		for (Store store : stores) {
			storeBiz.saveStore(store, reptile.getSchoolId(), reptile.getSortTypeId());
		}
		return view;
	}

}
