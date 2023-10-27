package com.dev.torhugo.challenge_idwall.lib.data.dto.annotation;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

@Builder
public record RequestAnnotationInfoDTO(
        String description,
        String email,
        String address,
        @JsonProperty("phone_number")
        String phoneNumber
) {
}
