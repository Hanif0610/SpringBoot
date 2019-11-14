package com.spring.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import com.spring.repository.UsersRepository;
import com.spring.service.JoinService;

@Controller
public class UsersController {
	
	@Autowired
	private UsersRepository usersRepository;
	
	@PostMapping(value = "/joinRequest")
	public String joinrequest(HttpServletRequest request) {
		JoinService joinService = new JoinService();
		joinService.joinUser(request, usersRepository);
		return "index";
	}
	
	@PostMapping(value = "/loginRequest")
	public String loginrequest() {
		return "index";
	}
}
