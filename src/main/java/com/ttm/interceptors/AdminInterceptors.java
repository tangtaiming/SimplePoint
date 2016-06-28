package com.ttm.interceptors;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.ttm.orm.User;
import com.ttm.util.Md5;

public class AdminInterceptors implements HandlerInterceptor {

	private static final Logger logger = Logger.getLogger(AdminInterceptors.class);

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		String path = request.getServletPath();
		System.out.println(path);
		if (path.contains("/store/") || path.contains("/school") || path.contains("/reptile")
				|| path.contains("/shuiguo") || path.contains("/meishijia") || path.contains("/shipin")
				|| path.contains("/meishi") || path.contains("/safety") || path.contains("/school_module")
				|| path.contains("/preferential") || path.contains("/admin")) {
			HttpSession session = request.getSession();
			User user = (User) session.getAttribute("user");
			if (user == null) {
				logger.info("用户没有登录");
				response.sendRedirect("/login");
			}
		}
		return true;
	}

	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		request.setAttribute("code", Md5.getEncode(new Date().toString()));
	}

	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
	}

}
