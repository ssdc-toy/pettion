package com.pettion.server.global.embedded;

import jakarta.persistence.Embeddable;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Embeddable
public class BaseTime {
    private LocalDateTime createAt;
    private LocalDateTime updateAt;
    private LocalDateTime deleteAt;

    public BaseTime() {
        createAt = LocalDateTime.now();
        updateAt = LocalDateTime.now();
    }

    public void update() {
        updateAt = LocalDateTime.now();
    }

    public void delete() {
        deleteAt = LocalDateTime.now();
    }
}
