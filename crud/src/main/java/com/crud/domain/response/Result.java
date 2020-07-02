package com.crud.domain.response;

import lombok.Data;

@Data
public class Result<T> {

    private String result;
    private String message;
    private T response;
}
