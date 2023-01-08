package com.pettion.server.global.config.security.oauth2;

import com.pettion.server.global.config.security.oauth2.attributemapper.AttributeMapper;
import com.pettion.server.model.bidder.entity.AuthProvider;
import com.pettion.server.model.bidder.entity.Bidder;
import com.pettion.server.model.bidder.mapper.BidderMapper;
import com.pettion.server.model.bidder.service.BidderService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * User 인증 후 계정이 있으면 그대로 불러오고, 없으면 신규 생성하여 유저를 불러옴
 *
 * @author Hyeonjun Park
 */
@Service
@RequiredArgsConstructor
public class OAuth2UserServiceImpl extends DefaultOAuth2UserService {
    private final AttributeMapper attributeMapper;
    private final BidderService bidderService;
    private final BidderMapper bidderMapper;

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        AuthProvider authProvider = AuthProvider
                .valueOf(userRequest
                        .getClientRegistration()
                        .getClientName()
                        .toUpperCase());
        OAuth2User oAuth2User = super.loadUser(userRequest);
        OAuth2Request oAuth2Request = attributeMapper.mapToUser(authProvider, oAuth2User.getAttributes());
        saveIfNone(oAuth2Request);
        Bidder user = bidderService.findByAccountId(oAuth2Request.getAccountId());
        Map<String, Object> userAttributes = bidderMapper.mapToAttributeMap(user);

        return new DefaultOAuth2User(user.getRole(), userAttributes, "id");
    }

    private void saveIfNone(OAuth2Request oAuth2Request) {
        if (!bidderService.isExistByAccountId(oAuth2Request.getAccountId())) {
            bidderService.create(oAuth2Request);
        }
    }
}
