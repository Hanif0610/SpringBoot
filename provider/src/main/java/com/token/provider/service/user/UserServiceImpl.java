package com.token.provider.service.user;

import com.token.provider.domain.request.SignUpRequest;
import com.token.provider.entity.User;
import com.token.provider.entity.repository.UserRepository;
import com.token.provider.exception.UserAlreadyExistsException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    @Override
    public void signup(SignUpRequest signUpRequest) {

        if(userRepository.findByEmail(signUpRequest.getEmail()).isPresent()) throw new UserAlreadyExistsException();

        String email = signUpRequest.getEmail();
        String name = signUpRequest.getName();
        String password = passwordEncoder.encode(signUpRequest.getPassword());

        userRepository.save(
                User.builder()
                        .email(email)
                        .password(password)
                        .name(name)
                        .build()
        );
    }
}
