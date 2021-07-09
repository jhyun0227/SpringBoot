package com.ch.member.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;

public class SessionChk implements HandlerInterceptor {
	@Override
	// login 하지 않으면 사용하지 못하게
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession();
		if (session == null || session.getAttribute("id") == null || session.getAttribute("id").equals("")) {
			response.sendRedirect("loginForm.do");
			return false;
		}
		return true;
	}
}
