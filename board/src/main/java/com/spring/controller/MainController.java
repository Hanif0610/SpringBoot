package com.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class MainController {

	@Autowired
	private HttpSession session;
	
	@GetMapping(value = "/")
	public String index() {
		return "index";
	}
	
	@GetMapping(value = "/joinPage")
	public String joinPage() {
		return "join";
	}

	@GetMapping(value = "/loginPage")
	public String loginPage() {
		return "login";
	}

	@GetMapping(value = "/logout")
	public String logout() {
		session.invalidate();
		return "index";
	}
}
