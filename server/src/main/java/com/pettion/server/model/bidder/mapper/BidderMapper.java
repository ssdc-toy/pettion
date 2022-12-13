package com.pettion.server.model.bidder.mapper;

import com.pettion.server.model.bidder.dto.request.SignupRequest;
import com.pettion.server.model.bidder.entity.Bidder;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BidderMapper {

    private final PasswordEncoder passwordEncoder;

    public Bidder mapToEntity(SignupRequest dto) {
        return Bidder.builder()
                .accountId(dto.getAccountId())
                .nickname(dto.getNickname())
                .password(passwordEncoder.encode(dto.getPassword()))
                .build();
    }
}
