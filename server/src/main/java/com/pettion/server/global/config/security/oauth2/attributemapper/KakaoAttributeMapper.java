package com.pettion.server.global.config.security.oauth2.attributemapper;

import com.pettion.server.global.config.security.oauth2.OAuth2Request;
import com.pettion.server.model.bidder.entity.AuthProvider;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author Hyeonjun Park
 */
@Component
public class KakaoAttributeMapper implements AttributeMappable {
    @Override
    public OAuth2Request mapToDTO(Map<String, Object> attributes) {
        String accountId = ((Integer)attributes.get("id")).toString();
        String email = (String) attributes.get("email");
        String name = "sample";
        return new OAuth2Request(accountId, name, email, AuthProvider.KAKAO);
    }
}
