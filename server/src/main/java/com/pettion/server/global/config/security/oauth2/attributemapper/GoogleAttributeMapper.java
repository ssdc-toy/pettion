package com.pettion.server.global.config.security.oauth2.attributemapper;

import com.pettion.server.global.config.security.oauth2.OAuth2Request;
import com.pettion.server.model.bidder.entity.AuthProvider;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class GoogleAttributeMapper implements AttributeMappable {
    @Override
    public OAuth2Request mapToDTO(Map<String, Object> attributes) {
        String accountId = (String)attributes.get("sub");
        String name = (String)attributes.get("name");
        String email = (String)attributes.get("email");
        return new OAuth2Request(accountId, name, email, AuthProvider.GOOGLE);
    }


}