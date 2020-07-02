package com.crud.service.user;

import com.crud.domain.request.SignUp;
import com.crud.domain.response.Result;
import org.springframework.http.ResponseEntity;

public interface UserService {

    ResponseEntity<Result> signUp(SignUp signUp);
}
