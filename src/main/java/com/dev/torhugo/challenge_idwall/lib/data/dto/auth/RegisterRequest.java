package com.dev.torhugo.challenge_idwall.lib.data.dto.auth;

import lombok.Builder;

@Builder
public record RegisterRequest(
        String name,
        String lastname,
        String email,
        String password,
        String phone
) {
}
