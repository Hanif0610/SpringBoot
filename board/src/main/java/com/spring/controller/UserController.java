package com.spring.controller;

import com.spring.repository.UserRepository;
import com.spring.service.JoinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class UserController {

    @Autowired
    private UserRepository userRepository;

    //join.html에서 요청이 오면 이 구문을 실행함
    @PostMapping(value = "/joinRequest")
    public String joinRequest(HttpServletRequest request) {
        JoinService joinService = new JoinService();
        joinService.joinUser(request, userRepository);
        return "index";
    }

    @PostMapping(value = "/loginRequest")
    public String loginRequest() {
        return "index";
    }
}
