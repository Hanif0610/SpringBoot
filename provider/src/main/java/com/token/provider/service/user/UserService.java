package com.token.provider.service.user;

import com.token.provider.domain.request.SignUpRequest;

public interface UserService {

    void signup(SignUpRequest signUpRequest);
}
