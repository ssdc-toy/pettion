package com.pettion.server.bidder.service;

import com.pettion.server.bidder.dto.request.SignupRequest;
import com.pettion.server.bidder.dto.response.BidderResponse;
import com.pettion.server.bidder.entity.Bidder;
import com.pettion.server.bidder.repository.BidderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BidderService {
    private final BidderRepository bidderRepository;
    public BidderResponse signup(SignupRequest dto) {
        Bidder result = bidderRepository.save(dto);

        return new BidderResponse(result);
    }
}
