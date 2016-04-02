package com.ttm.action;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ttm.biz.PreferentialBiz;
import com.ttm.biz.impl.PreferentialBizImpl;
import com.ttm.orm.Preferential;
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
public class PreferentialAction {

	private ModelAndView view = new ModelAndView();
	
	private PreferentialBiz preferentialBiz = new PreferentialBizImpl();
	
	@RequestMapping(value = "preferential", params = { "page", "size" }, method = RequestMethod.GET)
	public ModelAndView preferential(@RequestParam(value = "page") int page, @RequestParam(value = "size") int size,
			@RequestParam(value = "sea", required = false) String sea, @RequestParam(value = "sort", required = false) String sort) {
		view.setViewName("/competence/preferential");
		return view;
	}
	
	@RequestMapping(value = "preferential", method = RequestMethod.GET)
	public ModelAndView  preferential() {
		List<Preferential> preferentialsList = preferentialBiz.findPreferentialList("id", ServiceSorterHelper.ASC);
		view.addObject("preferentialsList", preferentialsList);
		view.setViewName("/competence/edit-preferential");
		Dumper.dump(preferentialsList);
		return view;
	}
	
}
