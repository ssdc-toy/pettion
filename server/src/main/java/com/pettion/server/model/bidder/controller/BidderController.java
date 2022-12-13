package com.pettion.server.model.bidder.controller;

import com.pettion.server.model.bidder.dto.request.SignupRequest;
import com.pettion.server.model.bidder.dto.response.BidderResponse;
import com.pettion.server.model.bidder.service.BidderService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/bidder")
public class BidderController {
    private final BidderService bidderService;
    @PostMapping
    public ResponseEntity<BidderResponse> signup(@Valid @RequestBody SignupRequest dto) {
        BidderResponse result = bidderService.signup(dto);

        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }
}
