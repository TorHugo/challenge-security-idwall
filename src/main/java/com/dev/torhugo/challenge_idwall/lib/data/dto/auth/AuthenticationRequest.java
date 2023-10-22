package com.dev.torhugo.challenge_idwall.lib.data.dto.auth;

import lombok.Builder;

@Builder
public record AuthenticationRequest(
        String email,
        String password
) {
}
