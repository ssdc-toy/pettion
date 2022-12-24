package com.pettion.server.model.bidder.entity;

import com.pettion.server.global.embedded.BaseTime;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
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
    @Enumerated(EnumType.STRING)
    private Role role = Role.ROLE_USER;
    @Embedded
    private BaseTime basetime;

    @Builder
    public Bidder(String accountId, String password, String nickname) {
        this.accountId = accountId;
        this.password = password;
        this.nickname = nickname;

        basetime = new BaseTime();
    }
}
