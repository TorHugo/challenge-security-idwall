package com.dev.torhugo.challenge_idwall.lib.data.dto.verify;

import lombok.Builder;

import java.util.List;

@Builder
public record ResponseVerifyAmlDTO(
        Long items,
        List<BaseSuspectDTO> suspects
) {
}
