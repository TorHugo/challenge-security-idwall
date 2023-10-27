package com.dev.torhugo.challenge_idwall.lib.data.dto.verify.suspect;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

@Builder
public record ResponseSuspectCharacteristicDTO(
        @JsonInclude(JsonInclude.Include.NON_NULL)
        @JsonProperty("age_range")
        String ageRange,
        @JsonInclude(JsonInclude.Include.NON_NULL)
        @JsonProperty("birth_place")
        String birthPlace,
        @JsonInclude(JsonInclude.Include.NON_NULL)
        @JsonProperty("eye_color")
        String eyeColor,
        @JsonInclude(JsonInclude.Include.NON_NULL)
        String ethnicity,
        @JsonInclude(JsonInclude.Include.NON_NULL)
        String height,
        @JsonInclude(JsonInclude.Include.NON_NULL)
        String weight,
        @JsonInclude(JsonInclude.Include.NON_NULL)
        String nationality,
        @JsonInclude(JsonInclude.Include.NON_NULL)
        String sex) {
}