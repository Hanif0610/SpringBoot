package com.spring.execption;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler({ InvalidBodyException.class })
    protected ResponseEntity<Object> loginBodyNotFound(Exception ex, WebRequest request) {
        return handleExceptionInternal(ex, "Body not found",
                new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }

    @ExceptionHandler({ UserNotFoundException.class })
    protected ResponseEntity<Object> userNotFound(Exception ex, WebRequest request) {
        return handleExceptionInternal(ex, "User not found",
                new HttpHeaders(), HttpStatus.FORBIDDEN, request);
    }

    @ExceptionHandler(SignUpFaildException.class)
    protected ResponseEntity<Object> signUpFaild(Exception ex, WebRequest request) {
        return handleExceptionInternal(ex, "User Alredy Exits",
                new HttpHeaders(), HttpStatus.CONFLICT, request);
    }
}