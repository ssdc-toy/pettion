package com.pettion.server.global.config.security.oauth2;

import com.pettion.server.model.bidder.entity.AuthProvider;
import lombok.Getter;

import java.util.Optional;

@Getter
public class OAuth2Request {
    private String accountId;
    private Optional<String> name;
    private Optional<String> email;
    private AuthProvider provider;

    public OAuth2Request(String accountId, String name, String email, AuthProvider provider) {
        this.accountId = accountId;
        this.name = Optional.ofNullable(name);
        this.email = Optional.ofNullable(email);
        this.provider = provider;
    }
}
