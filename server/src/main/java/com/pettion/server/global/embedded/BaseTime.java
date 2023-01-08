package com.pettion.server.global.embedded;

import lombok.Getter;

import javax.persistence.Embeddable;
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
