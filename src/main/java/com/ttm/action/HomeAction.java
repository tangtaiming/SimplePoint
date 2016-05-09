package com.ttm.action;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
import com.ttm.enums.MoKuaiLeiXinEnum;
import com.ttm.orm.MeiShi;
import com.ttm.orm.MeiShiJia;
import com.ttm.orm.Preferential;
import com.ttm.orm.Safety;
import com.ttm.orm.ShiPin;
import com.ttm.orm.ShuiGuo;
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
	
	private MeiShiJiaBiz meiShiJiaBiz = new MeiShiJiaBizImpl();
	
	private ShiPinBiz shiPinBiz = new ShiPinBizImpl();
	
	private ShuiGuoBiz shuiGuoBiz = new ShuiGuoBizImpl();
	
	private ModelAndView view = new ModelAndView();

	/**
	 * 当前页
	 */
	private Integer page = 1;
	
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public ModelAndView index() {
		//显示数量
		Integer size = 27;
		List<Preferential> preferentialsList = preferentialBiz.findPreferentialList("id", ServiceSorterHelper.ASC);
		List<Store> storesList = storeBiz.findStoreList(page, size, "salesQuantity");
		view.addObject("storesList", storesList);
		view.addObject("preferentialsList", preferentialsList);
		
		//安全模块  默认第一页 (page)，查询数量 (size)，类型是安全 (type)，根据mark排序 升序排序 (mark)
		String sortName = "mark";
		size = 10;
		//模块类型 
		Integer type = MoKuaiLeiXinEnum.SHIWU_ANQUAN.getType();
		List<Safety> safetiesList = safetyBiz.findSafetyList(page, size, type, sortName);
		view.addObject("safetiesList", safetiesList);
		
		//美食模块  默认第一页 (page)，查询数量 (size)，类型是美食 (type)，根据mark排序 升序排序 (mark)
		type = MoKuaiLeiXinEnum.MEISHI.getType();
		List<MeiShi> meiShisList = meiShiBiz.findMeiShiList(page, size, type, sortName);
		view.addObject("meiShisList", meiShisList);
		
		//美食家模块  默认第一页 (page)，查询数量 (size)，类型是美食家 (type)，根据mark排序 升序排序 (mark)
		type = MoKuaiLeiXinEnum.MEISHI_JIA.getType();
		List<MeiShiJia> meiShiJiasList = meiShiJiaBiz.findMeiShiJiaList(page, size, type, sortName);
		view.addObject("meiShiJiasList", meiShiJiasList);
		
		//视频模块  默认第一页 (page)，查询数量 (size)，类型是视频 (type)，根据mark排序 升序排序 (mark)
		type = MoKuaiLeiXinEnum.SHIPIN.getType();
		List<ShiPin> shiPins = shiPinBiz.findShiPinList(page, size, type, sortName);
		view.addObject("shiPins", shiPins);
		
		//水果模块  默认第一页 (page)，查询数量 (size)，类型是水果 (type)，根据mark排序 升序排序 (mark)
		type = MoKuaiLeiXinEnum.SHUIGUO.getType();
		List<ShuiGuo> shuiGuosList = shuiGuoBiz.findShuiGuoList(page, size, type, sortName);
		view.addObject("shuiGuosList", shuiGuosList);
		
		view.setViewName("/index");
		return view;
	}
	
}
