package com.pettion.server.global.config.security.oauth2.attributemapper;

import com.pettion.server.model.bidder.entity.AuthProvider;
import org.springframework.stereotype.Component;

import java.util.EnumMap;
import java.util.Map;

@Component
public class AttributeMapperFactory {
    private final Map<AuthProvider, AttributeMappable> mapperMap = new EnumMap<>(AuthProvider.class);
    private final GoogleAttributeMapper googleAttributeMapper;
    private final KakaoAttributeMapper kakaoAttributeMapper;
    private final NaverAttributeMapper naverAttributeMapper;


    public AttributeMapperFactory(GoogleAttributeMapper googleAttributeMapper, KakaoAttributeMapper kakaoAttributeMapper, NaverAttributeMapper naverAttributeMapper) {
        this.googleAttributeMapper = googleAttributeMapper;
        this.kakaoAttributeMapper = kakaoAttributeMapper;
        this.naverAttributeMapper = naverAttributeMapper;
        initialize();
    }
    private void initialize() {
        mapperMap.put(AuthProvider.GOOGLE,new GoogleAttributeMapper());
        mapperMap.put(AuthProvider.KAKAO, new KakaoAttributeMapper());
        mapperMap.put(AuthProvider.NAVER, new NaverAttributeMapper());
    }

    public AttributeMappable get(AuthProvider authProvider) {
        return mapperMap.get(authProvider);
    }
}
