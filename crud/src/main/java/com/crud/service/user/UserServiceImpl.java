package com.crud.service.user;

import com.crud.domain.request.SignUp;
import com.crud.entity.User;
import com.crud.entity.repository.UserRepository;
import com.crud.util.PasswordEncoder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    @Override
    public void signUp(SignUp signUp) {
        String email = signUp.getEmail();
        String name = signUp.getName();
        String password = passwordEncoder.encode(signUp.getPassword());

        userRepository.save(
                User.builder()
                    .email(email)
                    .password(password)
                    .name(name)
                    .build()
        );

    }
}
