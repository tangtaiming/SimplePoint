package com.ttm.interceptors;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.ttm.orm.User;
import com.ttm.util.Dumper;
import com.ttm.util.Md5;

public class AdminInterceptors implements HandlerInterceptor {
	
	private static final Logger logger = Logger.getLogger(AdminInterceptors.class);
	
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("^^^^^^^^^^^^^^^^^^^" + request.getServletPath());
//		if (!request.getServletPath().equals("/home")) {
//			response.sendRedirect("/competence/error.jsp");
//		}
		return true;
	}

	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		request.setAttribute("code", Md5.getEncode(new Date().toString()));
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		System.out.println("^^^^^^^^^^^^^^postHandle");
		Dumper.dump(user);
	}

	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
	}

}
