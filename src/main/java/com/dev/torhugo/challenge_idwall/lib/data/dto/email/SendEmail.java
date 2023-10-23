package com.dev.torhugo.challenge_idwall.lib.data.dto.email;

import lombok.Builder;

@Builder
public record SendEmail(
        String ownerRef,
        String emailFrom,
        String emailTo,
        String subject,
        String text
) {
}
