package com.pettion.server.model.bidder.entity;

import com.pettion.server.global.embedded.BaseTime;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Bidder {
    @Id
    @GeneratedValue
    private Long id; // UUID로 변환 TODO
    @Column(nullable = false)
    private String accountId;
    @Column(nullable = false)
    private String nickname;
    @Column(nullable = false)
    private Integer point = 0;
    @ElementCollection(fetch = FetchType.EAGER)
    @Enumerated(EnumType.STRING)
    private final List<Role> role = new ArrayList<>(List.of(Role.ROLE_USER));
    @Embedded
    private BaseTime basetime;

    @Enumerated(EnumType.STRING)
    private AuthProvider authProvider = AuthProvider.NONE;

    @Builder
    public Bidder(String accountId, String nickname, AuthProvider authProvider) {
        this.accountId = accountId;
        this.nickname = nickname;
        this.authProvider = authProvider;

        basetime = new BaseTime();
    }

    public List<SimpleGrantedAuthority> getRole() {
        return role.stream()
                .map(Role::name)
                .map(SimpleGrantedAuthority::new)
                .toList();
    }
}
