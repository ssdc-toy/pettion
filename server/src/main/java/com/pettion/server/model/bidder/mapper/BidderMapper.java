package com.pettion.server.model.bidder.mapper;

import com.pettion.server.model.bidder.entity.Bidder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class BidderMapper {


    public Map<String, Object> mapToAttributeMap(Bidder user) {
        Map<String, Object> attributes = new HashMap<>();
        attributes.put("id", user.getId());
        attributes.put("accountId", user.getAccountId());
        attributes.put("nickname", user.getNickname());

        return attributes;
    }
}
