package com.ttm.action;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ttm.biz.SchoolBiz;
import com.ttm.biz.impl.SchoolBizImpl;
import com.ttm.orm.School;
import com.ttm.util.Dumper;

@Controller
public class SchoolAction {

	public SchoolBiz schoolBiz = new SchoolBizImpl();

	private ModelAndView view = new ModelAndView();

	/**
	 * 学校列表页面
	 * 
	 * @param page
	 *            当前页
	 * @param size
	 *            每页显示数量
	 * @return
	 */
	@RequestMapping(value = "school", params = { "page", "size" }, method = RequestMethod.GET)
	public ModelAndView school(@RequestParam(value = "page") int page, @RequestParam(value = "size") int size,
			@RequestParam(value = "sea", required = false) String sea, @RequestParam(value = "sort", required = false) String sort) {
		List<School> schoolsList = schoolBiz.findSchoolList(page, size);
		view.addObject("schoolsList", schoolsList);
		// 设置分页对象
		view.addObject("page", ((SchoolBizImpl) schoolBiz).getPage());
		view.addObject("showPage", ((SchoolBizImpl) schoolBiz).getShowPage());
		view.setViewName("competence/school");
		return view;
	}

	/**
	 * 新增学校数据页面
	 * 
	 * @return
	 */
	@RequestMapping(value = "school", method = RequestMethod.GET)
	public String school() {
		return "competence/add-school";
	}

	/**
	 * 保存新增学校数据
	 * 
	 * @param school
	 * @return
	 */
	@RequestMapping(value = "school", method = RequestMethod.POST)
	public String school(School school) {
		Dumper.dump(school);
		// 页面提供了 学校名称 / 学校代码 / 登录用户 / 创建时间
		// 创建时间
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String createDate = format.format(new Date());
		// 创建人
		Integer createId = 1;
		if (!(schoolBiz.saveSchool(school, createId, createDate))) {
			System.out.println("新增学校数据失败...");
			return "redirect:school";
		}
		return "redirect:school?page=1&size=20";
	}

	/**
	 * 删除学校信息
	 * 
	 * @param id
	 *            学校对应ID
	 * @return
	 */
	@RequestMapping(value = "school/{id}", method = RequestMethod.DELETE)
	public String school(@PathVariable(value = "id") Integer id) {
		schoolBiz.deleteSchool(id);
		return "redirect:/school?page=1&size=20";
	}

	/*
	 * 判断是否为整数
	 * 
	 * @param str 传入的字符串
	 * 
	 * @return 是整数返回true,否则返回false
	 */
	private boolean isInteger(String str) {
		Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");
		return pattern.matcher(str).matches();
	}

}
