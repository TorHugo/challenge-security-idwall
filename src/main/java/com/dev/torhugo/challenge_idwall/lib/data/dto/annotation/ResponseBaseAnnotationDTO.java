package com.dev.torhugo.challenge_idwall.lib.data.dto.annotation;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

import java.util.List;

@Builder
public record ResponseBaseAnnotationDTO(
        @JsonProperty("user_id")
        Long userId,
        @JsonProperty("_cards")
        List<ResponseAnnotationInfoDTO> cards
) {
}
