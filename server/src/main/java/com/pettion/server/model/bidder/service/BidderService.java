package com.pettion.server.model.bidder.service;

import com.pettion.server.model.bidder.dto.request.SignupRequest;
import com.pettion.server.model.bidder.dto.response.BidderResponse;
import com.pettion.server.model.bidder.entity.Bidder;
import com.pettion.server.model.bidder.mapper.BidderMapper;
import com.pettion.server.model.bidder.repository.BidderRepository;
import jakarta.persistence.EntityExistsException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BidderService {
    private final BidderRepository bidderRepository;
    private final BidderMapper bidderMapper;
    public BidderResponse signup(SignupRequest dto) {
        checkIsExist(dto);
        Bidder result = bidderRepository.save(bidderMapper.mapToEntity(dto));

        return new BidderResponse(result);
    }

    private void checkIsExist(SignupRequest dto) {
        if(bidderRepository.existsByAccountIdOOrNickname(dto.getAccountId(), dto.getNickname())) {
            throw new EntityExistsException();
        }
    }
}
