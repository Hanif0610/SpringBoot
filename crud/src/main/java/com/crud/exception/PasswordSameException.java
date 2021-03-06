package com.crud.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT, reason = "Password Same With Origin Password")
public class PasswordSameException extends RuntimeException {
    public PasswordSameException() {
        super();
    }
}