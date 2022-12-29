package com.pettion.server.global.config.security.jwt;

import com.pettion.server.model.bidder.service.BidderService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Collection;

/**
 * jwt token을 검증
 *
 * @author Hyeonjun Park
 */
@Component
@RequiredArgsConstructor
public class JwtValidator {
    private final Key key;
    private final BidderService bidderService;

    public Authentication getAuthentication(String accessToken) {
        Claims claims = getTokenBodyClaims(accessToken);
        Collection<? extends GrantedAuthority> authorities = extractAuthority(claims);
        UserDetails principal = new User(String.valueOf(claims.get("id")), "", authorities);

        return new UsernamePasswordAuthenticationToken(principal, "", authorities);
    }

    private Collection<? extends GrantedAuthority> extractAuthority(Claims claims) {
        return bidderService.getAuthority(parseLong(claims));
    }

    private Long parseLong(Claims claims) {
        return Long.valueOf(String.valueOf(claims.get("id")));
    }

    private Claims getTokenBodyClaims(String accessToken) {
        return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(accessToken)
                .getBody();
    }
}
