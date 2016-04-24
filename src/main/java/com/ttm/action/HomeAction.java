package com.ttm.action;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ttm.biz.MeiShiBiz;
import com.ttm.biz.PreferentialBiz;
import com.ttm.biz.SafetyBiz;
import com.ttm.biz.StoreBiz;
import com.ttm.biz.impl.MeiShiBizImpl;
import com.ttm.biz.impl.MeiShiJiaBizImpl;
import com.ttm.biz.impl.PreferentialBizImpl;
import com.ttm.biz.impl.SafetyBizImpl;
import com.ttm.biz.impl.StoreBizImpl;
import com.ttm.orm.MeiShi;
import com.ttm.orm.Preferential;
import com.ttm.orm.Safety;
import com.ttm.orm.Store;
import com.ttm.util.ServiceSorterHelper;

/**
 * 
 * <p>介绍：首页 部分</p>
 * @author 唐太明
 * @date 2016年4月3日 下午5:31:26
 * @version 1.0
 */
@Controller
public class HomeAction {
	
	private PreferentialBiz preferentialBiz = new PreferentialBizImpl();
	
	private StoreBiz storeBiz = new StoreBizImpl();
	
	private SafetyBiz safetyBiz = new SafetyBizImpl();
	
	private MeiShiBiz meiShiBiz = new MeiShiBizImpl();
	
	private ModelAndView view = new ModelAndView();
	
	//1 代表 安全
	private Integer type;
	
	/**
	 * 当前页
	 */
	private Integer page = 1;
	
	/**
	 * 每页显示数量
	 */
	private Integer size = 27;
	
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public ModelAndView index() {
		List<Preferential> preferentialsList = preferentialBiz.findPreferentialList("id", ServiceSorterHelper.ASC);
		List<Store> storesList = storeBiz.findStoreList(page, size, "salesQuantity");
		view.addObject("storesList", storesList);
		view.addObject("preferentialsList", preferentialsList);
		
		//安全模块  默认第一页 (page)，查询数量 (size)，类型是安全 (type)，根据mark排序 升序排序 (mark)
		String sortName = "mark";
		size = 10;
		type = 1;
		List<Safety> safetiesList = safetyBiz.findSafetyList(page, size, type, sortName);
		
		type = 2;
		List<MeiShi> meiShisList = meiShiBiz.findMeiShiList(page, size, type, sortName);
		view.addObject("safetiesList", safetiesList);
		view.setViewName("/index");
		
		return view;
	}
	
}
