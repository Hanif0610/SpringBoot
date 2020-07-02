package com.crud.domain.request;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class SignUp {

    private String email;

    private String password;

    private String name;
}
