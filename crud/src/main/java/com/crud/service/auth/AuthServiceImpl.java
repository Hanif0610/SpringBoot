package com.crud.service.auth;

import com.crud.domain.request.SignIn;
import com.crud.domain.response.TokenResponse;
import com.crud.entity.User;
import com.crud.entity.repository.UserRepository;
import com.crud.exception.UserNotFoundException;
import com.crud.util.JwtTokenUtil;
import com.crud.util.PasswordEncoder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;

    @Override
    public TokenResponse signIn(SignIn signIn) {
        User user = userRepository.findByEmail(signIn.getEmail())
                .filter(data -> PasswordEncoder.checkPassword(data.getPassword(), signIn.getPassword()))
                .orElseThrow(UserNotFoundException::new);

        return new TokenResponse(user.getId());
    }

    @Override
    public TokenResponse refreshToken(String token) {
        Integer uuid = JwtTokenUtil.parseRefreshToken(token);
        return new TokenResponse(uuid);
    }
}
