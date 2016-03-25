package com.ttm.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ttm.orm.School;
import com.ttm.util.Dumper;

@Controller
public class SchoolAction {

	/**
	 * 学校列表页面
	 * @param page 当前页
	 * @param size 每页显示数量
	 * @return
	 */
	@RequestMapping(value = "school", params = {"page", "size"} , method = RequestMethod.GET)
	public String school(@RequestParam(value="page") int page, @RequestParam(value="size") int size) {
		return "competence/school";
	}
	
	/**
	 * 新增学校
	 * @return
	 */
	@RequestMapping(value = "school", method = RequestMethod.GET)
	public String school() {
		return "competence/add-school";
	}
	
	@RequestMapping(value="school", method = RequestMethod.POST)
	public String school(@RequestBody School school) {
		Dumper.dump(school);
		return "";
	}
	
	
}
