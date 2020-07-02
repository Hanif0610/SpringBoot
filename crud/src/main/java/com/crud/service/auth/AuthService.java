package com.crud.service.auth;

import com.crud.domain.request.SignIn;
import com.crud.domain.response.TokenResponse;

public interface AuthService {

    TokenResponse signIn(SignIn signIn);
    TokenResponse refreshToken(String token);
}
