package com.dev.torhugo.challenge_idwall.lib.data.domain;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public abstract class BaseModel {
    private LocalDateTime creatAt;
    private LocalDateTime updateAt;
}
