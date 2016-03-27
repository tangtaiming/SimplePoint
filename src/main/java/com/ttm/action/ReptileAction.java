package com.ttm.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ttm.orm.Reptile;

/**
 * 
 * <p>介绍:URL action</p>
 * @author 唐太明
 * @date 2016年3月25日 下午8:33:55
 * @version 1.0
 */
@Controller
public class ReptileAction {

	/**
	 * 爬虫页面
	 * @param page
	 * @param size
	 * @return
	 */
	@RequestMapping(value = "reptile", params = {"page", "size"}, method = RequestMethod.GET)
	public String reptile(@RequestParam("page") int page, @RequestParam("size") int size) {
		return "competence/reptile";
	}
	
	/**
	 * 进入爬虫新增页面
	 * @return
	 */
	@RequestMapping(value = "reptile", method = RequestMethod.GET)
	public String reptile() {
		return "competence/add-reptile";
	}
	
	/**
	 * 保存新增加爬虫
	 * @param reptile
	 * @return
	 */
	@RequestMapping(value = "reptile", method = RequestMethod.POST)
	public String reptile(@RequestBody Reptile reptile) {
		return "";
	}
	
	/**
	 * 进入开启对应地址爬虫
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "reptile/{id}/start", method = RequestMethod.GET)
	public String start(@PathVariable(value = "id") int id) {
		return "";
	}
	
	/**
	 * 开启对应地址爬虫
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "reptile/{id}/start", params = {"type"}, method = RequestMethod.POST)
	public String start(@PathVariable(value = "id") int id, @RequestParam(value = "type") String type) {
		System.out.println("开启一个线程，请等待...");
		return "";
	}
	
}
