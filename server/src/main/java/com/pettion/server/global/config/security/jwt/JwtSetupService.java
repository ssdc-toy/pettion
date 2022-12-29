package com.pettion.server.global.config.security.jwt;

import com.pettion.server.global.config.security.oauth2.LoginUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

/**
 * Client의 cookie로 token을 설정
 *
 * @author Hyeonjun Park
 */
@Slf4j
@Service
public class JwtSetupService {
    private final JwtProvider jwtProvider;

    private final String accessTokenHeaderTag;
    private final String refreshTokenHeaderTag;

    public JwtSetupService(JwtProvider jwtProvider,
                           @Value("${jwt.access-header}") String accessTokenHeaderTag,
                           @Value("${jwt.refresh-header}") String refreshTokenHeaderTag) {
        this.jwtProvider = jwtProvider;
        this.accessTokenHeaderTag = accessTokenHeaderTag;
        this.refreshTokenHeaderTag = refreshTokenHeaderTag;
    }

    public void addJwtTokensInCookie(HttpServletResponse response, LoginUser loginUser) {
        JwtToken jwtToken = jwtProvider.createJWTTokens(loginUser);
        Cookie accessTokenCookie = setCookie(accessTokenHeaderTag, jwtToken.getAccessToken());
        response.addCookie(accessTokenCookie);

        Cookie refreshTokenCookie = setCookie(refreshTokenHeaderTag, jwtToken.getRefreshToken());
        response.addCookie(refreshTokenCookie);
    }

    private Cookie setCookie(String key, String value) {
        Cookie cookie = new Cookie(key, value);
        cookie.setPath("/");
        cookie.setHttpOnly(true);
        return cookie;
    }
}
