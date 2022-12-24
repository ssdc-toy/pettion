package com.pettion.server.model.bidder.dto.response;

import com.pettion.server.model.bidder.entity.Bidder;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class BidderResponse {
    private Long id;
    private String accountId;
    private String nickname;
    private Integer point;

    public BidderResponse(Bidder result) {
        this.id = result.getId();
        this.accountId = result.getAccountId();
        this.nickname = result.getNickname();
        this.point = result.getPoint();
    }
}
