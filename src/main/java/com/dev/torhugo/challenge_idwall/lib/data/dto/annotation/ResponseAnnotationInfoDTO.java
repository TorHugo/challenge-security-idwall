package com.dev.torhugo.challenge_idwall.lib.data.dto.annotation;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Builder
public record ResponseAnnotationInfoDTO(
        @JsonProperty("annotation_id")
        Long annotationId,
        @JsonProperty("card_name")
        String cardName,
        @JsonProperty("card_description")
        String cardDescription,
        @JsonProperty("card_email")
        String cardEmail,
        @JsonProperty("card_address")
        String cardAddress,
        @JsonProperty("card_phone_number")
        String cardPhoneNumber,
        @JsonProperty("in_active")
        Boolean inActive,
        @JsonProperty("create_at")
        @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss", timezone = "UTC")
        LocalDateTime createAt
) {
}
