package com.token.provider.domain.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class SignUpRequest {

    @Email
    private String email;

    @NotNull
    private String password;

    @NotNull
    private String name;
}
