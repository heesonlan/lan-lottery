package com.lan.lottery.config.interceptors;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;

@Component
public class LoginInterceptor implements HandlerInterceptor{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession(false);
		if(session==null){
			response.sendRedirect(request.getContextPath()+"/login");
			return false;
		}
		String _id = (String)session.getAttribute("_ID");
		if(StringUtils.isEmpty(_id)){
			response.sendRedirect(request.getContextPath()+"/login");
            return false;
		}
		String sessionTime = _id.substring(_id.lastIndexOf("-")+1);
		if(new Date().getTime()-Long.valueOf(sessionTime)>7200000l){// 超过2小时，换session_id
		//	ApiUser user = RedisUtil.get(_id);
			String _newid = "wxSession£"+"user"+"-"+ new Date().getTime();
		//	RedisUtil.set(_newid, user, 3600*24);
			session.setAttribute("_ID", _newid);
		}
		return true;
	}
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
	}
	
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		
	}
}
