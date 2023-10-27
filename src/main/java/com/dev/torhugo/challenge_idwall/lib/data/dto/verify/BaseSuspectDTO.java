package com.dev.torhugo.challenge_idwall.lib.data.dto.verify;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

import java.util.List;

@Builder
public record BaseSuspectDTO(
        Long personId,
        String name,
        String description,
        @JsonProperty("criminal_classification")
        String criminalClassification,
        @JsonProperty("date_publication")
        String datePublication,
        @JsonProperty("_links")
        @JsonInclude(JsonInclude.Include.NON_NULL)
        List<BaseLinkSuspectDTO> links
) {
}
