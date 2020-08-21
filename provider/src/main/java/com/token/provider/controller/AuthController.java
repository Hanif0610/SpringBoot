package com.token.provider.controller;

import com.token.provider.domain.request.SignInRequest;
import com.token.provider.domain.response.TokenResponse;
import com.token.provider.service.auth.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping
    public TokenResponse login(@RequestBody @Valid SignInRequest signInRequest) {
        return authService.login(signInRequest);
    }

    @PutMapping
    public TokenResponse refreshToken(@RequestHeader("X-Refresh-Token") String refreshToken) {
        return authService.refreshToken(refreshToken);
    }
}
