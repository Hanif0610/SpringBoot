package com.crud.domain.request;

import lombok.Builder;
import lombok.Getter;

@Getter
public class SignIn {

    private String email;

    private String password;

    @Builder
    public SignIn(String email, String password) {
        this.email = email;
        this.password = password;
    }
}
