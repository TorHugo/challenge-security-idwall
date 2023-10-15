package com.dev.torhugo.challenge_idwall.util.resource;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HubResponse <T> {
    private LocalDateTime timeStamp;
    private Integer numberStatus;
    private transient T response;
    private String message;

    public HubResponse(final HubHttpEnum hubHttpEnum, final T data){
        this.timeStamp = LocalDateTime.now();
        this.numberStatus = hubHttpEnum.getHttpStatus().value();
        this.message = hubHttpEnum.getMessage();
        this.response = data;
    }
}
