package com.dev.torhugo.challenge_idwall.lib.data.dto.annotation;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

@Builder
public record RequestAnnotationDTO(
        @JsonProperty("user_id")
        Long userId,
        @JsonProperty("card_name")
        String cardName,
        @JsonProperty("card_info")
        RequestAnnotationInfoDTO cardInfo
) {
}
