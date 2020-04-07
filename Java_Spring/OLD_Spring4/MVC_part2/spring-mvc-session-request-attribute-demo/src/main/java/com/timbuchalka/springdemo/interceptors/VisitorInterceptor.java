package com.timbuchalka.springdemo.interceptors;

import java.time.LocalDateTime;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

@Service
public class VisitorInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		request.setAttribute("currentTime", LocalDateTime.now());
		
		HttpSession session = request.getSession(true);
		if(session.getAttribute("sessionStartTime") == null) {
			session.setAttribute("sessionStartTime", LocalDateTime.now());
		}
		return true;
	}
	
	

}
