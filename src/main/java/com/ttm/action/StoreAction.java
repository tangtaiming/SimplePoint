package com.ttm.action;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ttm.biz.StoreBiz;
import com.ttm.biz.impl.StoreBizImpl;
import com.ttm.orm.Store;

@Controller
public class StoreAction {
	
	private StoreBiz storeBiz = new StoreBizImpl();
	
	private ModelAndView view = new ModelAndView();

	@RequestMapping(value = "store", params = { "page", "size" }, method = RequestMethod.GET)
	public ModelAndView store(@RequestParam("page") int page, @RequestParam("size") int size,
			@RequestParam(value = "sea", required = false) String sea,
			@RequestParam(value = "sort", required = false) String sort) {
		List<Store> storesList = storeBiz.findStoreList(page, size);
		view.addObject("storesList", storesList);
		view.addObject("page", ((StoreBizImpl) storeBiz).getPage());
		view.addObject("showPage", ((StoreBizImpl) storeBiz).getShowPage());
		view.setViewName("");
		return view;
	}

}
