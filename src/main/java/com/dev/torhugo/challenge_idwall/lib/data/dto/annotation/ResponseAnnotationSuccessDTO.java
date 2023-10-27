package com.dev.torhugo.challenge_idwall.lib.data.dto.annotation;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record ResponseAnnotationSuccessDTO(
        @JsonProperty("annotation_id")
        Long annotationId,
        @JsonProperty("user_id")
        Long userId,
        @JsonProperty("create_at")
        @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss", timezone = "UTC")
        LocalDateTime createAt
) {
}
