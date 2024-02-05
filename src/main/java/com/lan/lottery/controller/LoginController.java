package com.lan.lottery.controller;


import com.lan.lottery.model.ApiUser;
import com.lan.lottery.model.MSG;
import com.lan.lottery.util.StringUtils;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Date;

@Slf4j
@RestController
public class LoginController {
	
	@Value("${login.user}")
	private String loginUser;
	
	@Value("${login.password}")
	private String loginPassword;
	
	@PostMapping("login")
	public MSG login(HttpServletRequest request, String userName, String password){
		if(StringUtils.isEmpty(userName) || StringUtils.isEmpty(password)){
			return MSG.error("账号密码不能为空");
		}
		if(loginUser.equals(userName) && loginPassword.equals(password)){
			HttpSession session = request.getSession();
			String _id = "wxSession£"+userName+"-"+ new Date().getTime();
			ApiUser user = new ApiUser();
			user.setUserName(userName);
			// 暂时不存储用户信息
			session.setAttribute("_ID", _id);
			return MSG.success();
		}
		return MSG.error("密码错误");
	}
	
	@RequestMapping("/api/logout")
	public MSG logout(HttpServletRequest request,  HttpServletResponse response){
		HttpSession session = request.getSession();
		String _id = (String) session.getAttribute("_ID");
		if(!StringUtils.isEmpty(_id)){
			// 暂时不需要清除用户信息
		}
		session.invalidate();
		try {
			response.sendRedirect(request.getContextPath()+"/login");
		} catch (IOException e) {
			log.error("登出失败",e);
		}
		return MSG.success();
	}

}
