package com.crud.domain.response;

import com.crud.util.JwtTokenUtil;
import lombok.Builder;
import lombok.Getter;

@Getter
public class TokenResponse {

    private String assessToken;
    private String refreshToken;

    @Builder
    public TokenResponse(Object obj) {
        this.assessToken = JwtTokenUtil.getAccessToken(obj);
        this.refreshToken = JwtTokenUtil.getRefreshToken(obj);
    }
}
