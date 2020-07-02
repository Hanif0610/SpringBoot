package com.crud.service.user;

import com.crud.entity.User;
import com.crud.domain.request.SignUp;
import com.crud.entity.repository.UserRepository;
import com.crud.domain.response.Result;
import com.crud.util.PasswordEncoder;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    @Override
    public ResponseEntity<Result> signUp(SignUp signUp) {
        Result<User> result = new Result<>();
        String email = signUp.getEmail();
        String name = signUp.getName();
        String password = passwordEncoder.encode(signUp.getPassword());

        try {
            User user = userRepository.save(
                    User.builder()
                        .email(email)
                        .password(password)
                        .name(name)
                        .type(0)
                        .build()
            );

            result.setResponse(user);
            return ResponseEntity.ok().body(result);
        } catch (Exception e) {
            result.setResult("ERROR");
            result.setMessage(e.getMessage());
            return new ResponseEntity<>(result, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
