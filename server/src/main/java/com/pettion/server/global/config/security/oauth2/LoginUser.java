package com.pettion.server.global.config.security.oauth2;

import io.jsonwebtoken.Claims;
import lombok.Getter;

@Getter
public class LoginUser {
    private Long id;
    private String nickname;

    public LoginUser(Claims claims) {
        this.id = Long.parseLong(claims.get("id").toString());
        this.nickname = claims.get("nickname").toString();
    }

    public LoginUser(Long id, String nickname) {
        this.id = id;
        this.nickname = nickname;
    }
}
