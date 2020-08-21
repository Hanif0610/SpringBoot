package com.token.provider.service.auth;

import com.token.provider.domain.request.SignInRequest;
import com.token.provider.domain.response.TokenResponse;

public interface AuthService {

    TokenResponse login(SignInRequest signInRequest);
    TokenResponse refreshToken(String refreshToken);
}
