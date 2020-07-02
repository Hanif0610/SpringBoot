package com.crud.controller;

import com.crud.domain.request.SignUp;
import com.crud.domain.response.Result;
import com.crud.service.user.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
@RequestMapping("/user")
public class UserController {

    private final UserServiceImpl userService;

    @GetMapping(value = "/")
    public String home() {

        return "home";
    }

    @PostMapping(value = "/signup")
    public ResponseEntity<Result> signIn(@RequestBody @Valid SignUp signUp) {
        userService.signUp(signUp);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
