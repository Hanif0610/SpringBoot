package com.crud.domain.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignIn {

    private String email;

    private String password;
}
