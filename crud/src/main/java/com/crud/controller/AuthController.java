package com.crud.controller;

import com.crud.domain.request.SignIn;
import com.crud.domain.response.TokenResponse;
import com.crud.service.auth.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping
    public TokenResponse signIn(@RequestBody @NotNull SignIn signIn) {
        return authService.signIn(signIn);
    }

    @PutMapping
    public TokenResponse refreshToken(@RequestHeader("Authorization") @NotNull String refreshToken) {
        return authService.refreshToken(refreshToken);
    }
}
