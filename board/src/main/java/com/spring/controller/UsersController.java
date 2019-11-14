package com.spring.controller;

import javax.servlet.http.HttpServletRequest;

import com.spring.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import com.spring.repository.UsersRepository;
import com.spring.service.JoinService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class UsersController {

	@Autowired
	private JoinService joinService;

	@Autowired
	private LoginService loginService;

	@PostMapping(value = "/joinRequest")
	public String joinRequest(@RequestParam Map<String, String> paraMap) {
		String userID = paraMap.get("user_id");
		String userPassword = paraMap.get("user_pw");
		String userName = paraMap.get("user_name");

		String page = joinService.joinUser(userID, userPassword, userName);
		return page;
	}
	
	@PostMapping(value = "/loginRequest")
	public String loginRequest(@RequestParam Map<String, String> paraMap) {
		String userID = paraMap.get("user_id");
		String userPassword = paraMap.get("user_pw");

		String page = loginService.login(userID, userPassword);
		return page;
	}
}
