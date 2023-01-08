package com.pettion.server.model.bidder.repository;

import com.pettion.server.model.bidder.entity.Bidder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BidderRepository extends JpaRepository<Bidder, Long> {
    boolean existsByAccountIdOrNickname(String accountId, String nickname);

    Optional<Bidder> findByAccountId(String accountId);
    boolean existsByAccountId(String accountId);
}
