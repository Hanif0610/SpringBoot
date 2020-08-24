package com.crud.domain.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignUp {

    private String email;

    private String password;

    private String name;
}
