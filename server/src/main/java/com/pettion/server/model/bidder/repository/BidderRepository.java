package com.pettion.server.model.bidder.repository;

import com.pettion.server.model.bidder.entity.Bidder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BidderRepository extends JpaRepository<Bidder, Long> {
    boolean existsByAccountIdOOrNickname(String accountId, String nickname);
}
