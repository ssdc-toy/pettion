package com.pettion.server.bidder.entity;

import com.pettion.server.global.Basetime;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Bidder {

    @Id
    @GeneratedValue
    private Long id;
    @Column(nullable = false)
    private String accountId;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private String nickname;
    @Column(nullable = false)
    private Integer point = 0;
    @Embedded
    private Basetime basetime;



}
