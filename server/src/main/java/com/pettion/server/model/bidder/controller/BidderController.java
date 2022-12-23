package com.pettion.server.model.bidder.controller;

import com.pettion.server.model.bidder.service.BidderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/bidders")
public class BidderController {
    private final BidderService bidderService;
}
