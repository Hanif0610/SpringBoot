package com.token.provider.service.auth;

import com.token.provider.domain.request.SignInRequest;
import com.token.provider.domain.response.TokenResponse;
import com.token.provider.entity.User;
import com.token.provider.entity.repository.UserRepository;
import com.token.provider.exception.InvalidTokenException;
import com.token.provider.exception.UserNotFoundException;
import com.token.provider.security.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    private final JwtTokenProvider jwtTokenProvider;

    @Value("${auth.jwt.prefix}")
    private String prefix;

    @Override
    public TokenResponse login(SignInRequest signInRequest) {
        User user = userRepository.findByEmail(signInRequest.getEmail())
                .filter(u -> passwordEncoder.matches(signInRequest.getPassword(), u.getPassword()))
                .orElseThrow(UserNotFoundException::new);

        return responseToken(user.getEmail());
    }

    @Override
    public TokenResponse refreshToken(String refreshToken) {
        if(!jwtTokenProvider.isRefreshToken(refreshToken)) throw new InvalidTokenException();
        String email = jwtTokenProvider.getUserEmail(refreshToken);
        return responseToken(email);
    }

    public TokenResponse responseToken(String email) {
        return TokenResponse.builder()
                .accessToken(jwtTokenProvider.generateAccessToken(email))
                .refreshToken(jwtTokenProvider.generateRefreshToken(email))
                .tokenType(prefix)
                .build();
    }
}
