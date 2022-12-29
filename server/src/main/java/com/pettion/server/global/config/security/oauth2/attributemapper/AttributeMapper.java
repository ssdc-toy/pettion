package com.pettion.server.global.config.security.oauth2.attributemapper;

import com.pettion.server.global.config.security.oauth2.OAuth2Request;
import com.pettion.server.model.bidder.entity.AuthProvider;
import com.pettion.server.model.bidder.entity.Bidder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * attribute값을 dto로, user을 attribute로 변환해주는 클래스
 *
 * @author Hyeonjun Park
 */
@Component
@RequiredArgsConstructor
public class AttributeMapper {

    private final AttributeMapperFactory attributeMapperFactory;

    public OAuth2Request mapToUser(AuthProvider provider, Map<String, Object> attributes) {
        return attributeMapperFactory.get(provider).mapToDTO(attributes);
    }

    public Map<String, Object> mapToAttribute(Bidder user) {
        Map<String, Object> result = new HashMap<>();
        result.put("id", user.getId());
        result.put("accountId", user.getAccountId());
        result.put("nickname", user.getNickname());
        result.put("role", user.getRole());
        return result;
    }
}
