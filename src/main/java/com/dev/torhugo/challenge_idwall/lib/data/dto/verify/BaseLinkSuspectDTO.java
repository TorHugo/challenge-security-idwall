package com.dev.torhugo.challenge_idwall.lib.data.dto.verify;

import lombok.Builder;

@Builder
public record BaseLinkSuspectDTO(
        String path,
        String method
) {
}
