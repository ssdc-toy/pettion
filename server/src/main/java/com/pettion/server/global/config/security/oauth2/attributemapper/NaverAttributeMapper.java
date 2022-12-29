package com.pettion.server.global.config.security.oauth2.attributemapper;

import com.pettion.server.global.config.security.oauth2.OAuth2Request;
import com.pettion.server.model.bidder.entity.AuthProvider;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class NaverAttributeMapper implements AttributeMappable {
    @Override
    public OAuth2Request mapToDTO(Map<String, Object> attributes) {

        Map<String, Object> response =
                (Map<String, Object>)attributes.get("response");

        String accountId = (String)response.get("id");
        String name = (String)response.get("name");
        String email = (String)response.get("email");
        return new OAuth2Request(accountId, name, email, AuthProvider.NAVER);
    }

}
