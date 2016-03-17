package com.ttm.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ttm.reptile.MeiTuanReptileFactory;

@Controller
@RequestMapping("t")
/**
 * 
 * <p>介绍</p>
 * @author 唐太明
 * @date 2016年3月16日上午9:13:00
 * @version 1.0
 */
public class TestAction {
	
	private MeiTuanReptileFactory factory = new MeiTuanReptileFactory();

	@RequestMapping(value = "startReptile", method = RequestMethod.GET)
	public String startReptile() {
		System.out.println("well come springMVC！");
		String url = "http://waimai.meituan.com/home/wsb0uqe32sz6";
		factory.startMeituan(url);
		return "startReptile";
	}
	
}
