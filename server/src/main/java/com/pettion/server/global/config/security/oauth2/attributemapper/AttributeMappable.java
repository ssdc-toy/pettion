package com.pettion.server.global.config.security.oauth2.attributemapper;

import com.pettion.server.global.config.security.oauth2.OAuth2Request;

import java.util.Map;

public interface AttributeMappable {
    OAuth2Request mapToDTO(Map<String, Object> attributes);


}
