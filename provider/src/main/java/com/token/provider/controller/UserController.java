package com.token.provider.controller;

import com.token.provider.domain.request.SignUpRequest;
import com.token.provider.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/signup")
    public void signup(@RequestBody @Valid SignUpRequest signUpRequest) {
        userService.signup(signUpRequest);
    }
}
