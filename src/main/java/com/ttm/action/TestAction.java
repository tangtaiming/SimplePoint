package com.ttm.action;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ttm.reptile.MeiTuanReptileFactory;


/**
 * 
 * <p>介绍</p>
 * @author 唐太明
 * @date 2016年3月16日上午9:13:00
 * @version 1.0
 */
@Controller
public class TestAction {
	
	private MeiTuanReptileFactory factory = new MeiTuanReptileFactory();
	
	private String name;
	
	private ModelAndView md = new ModelAndView();

	@RequestMapping(value = "startReptile", method = RequestMethod.GET)
	public String startReptile() {
		System.out.println("well come springMVC！");
		String url = "http://waimai.meituan.com/home/wsb0uqe32sz6";
		factory.startMeituan(url);
		return "startReptile";
	}
	
	/**
	 * 登录后主页面
	 * @return
	 */
	@RequestMapping(value = "loginIndex", method = RequestMethod.GET)
	public String loginIndex() {
		return "competence/sort";
	}
	
	@RequestMapping(value = "testShow", method = RequestMethod.GET)
	public ModelAndView testShow() {
		md.addObject("name", "xiaoming");
		md.setViewName("competence/success");
		return md;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
