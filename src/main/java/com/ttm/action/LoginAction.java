package com.ttm.action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.ttm.biz.UserBiz;
import com.ttm.biz.impl.UserBizImpl;
import com.ttm.orm.User;
import com.ttm.util.Dumper;
import com.ttm.util.Json;

/**
 * 
 * <p>
 * 介绍
 * </p>
 * 
 * @author 唐太明
 * @date 2016年3月16日上午9:13:00
 * @version 1.0
 */
@Controller
public class LoginAction {

	private String name;

	private ModelAndView view = new ModelAndView();
	
	private UserBiz userBiz = new UserBizImpl();

	/**
	 * 登录
	 * @param user
	 * @return
	 */
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView login(HttpServletRequest request) {
		System.out.println("^^^^^^^^^^^^^^^^^^^^^post");
		String account = request.getParameter("account");
		String password = request.getParameter("password");
		User user = userBiz.login(account, password);
		System.out.println("^^^^^^^^^^^^^^^^^^");
		if (user != null) {
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
			System.out.println("获取数据成功");
		} else {
			System.out.println("获取数据失败");
		}
		Dumper.dump(user);
		view.setViewName("/competence/index");
		return view;
	}

	/**
	 * 进入登录页面
	 * 
	 * @return
	 */
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login() {
		view.setViewName("/competence/login");
		return view;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
