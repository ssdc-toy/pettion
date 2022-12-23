package com.pettion.server.model.bidder.service;

import com.pettion.server.model.bidder.mapper.BidderMapper;
import com.pettion.server.model.bidder.repository.BidderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BidderService {
    private final BidderRepository bidderRepository;
    private final BidderMapper bidderMapper;
}
