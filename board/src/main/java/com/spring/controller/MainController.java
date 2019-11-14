package com.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	
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
}
