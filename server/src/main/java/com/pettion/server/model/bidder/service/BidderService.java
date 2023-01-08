package com.pettion.server.model.bidder.service;

import com.pettion.server.global.config.security.oauth2.OAuth2Request;
import com.pettion.server.model.bidder.entity.Bidder;
import com.pettion.server.model.bidder.mapper.BidderMapper;
import com.pettion.server.model.bidder.repository.BidderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Collection;

@Service
@RequiredArgsConstructor
public class BidderService {
    private final BidderRepository bidderRepository;
    private final BidderMapper bidderMapper;


    public Collection<? extends GrantedAuthority> getAuthority(Long id) {
        return getEntity(id).getRole();
    }

    public void create(OAuth2Request dto) {
        Bidder.BidderBuilder bidderBuilder = Bidder.builder()
                .accountId(dto.getAccountId())
                .authProvider(dto.getProvider());
        dto.getName().ifPresent(bidderBuilder::nickname);

        bidderRepository.save(bidderBuilder.build());
    }

    public boolean isExistByAccountId(String accountId) {
        return bidderRepository.existsByAccountId(accountId);
    }


    public Bidder findByAccountId(String accountId) {
        return bidderRepository.findByAccountId(accountId).orElseThrow(EntityNotFoundException::new);
    }

    private Bidder getEntity(Long id) {
        return bidderRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }
}
