package com.dev.torhugo.challenge_idwall.lib.data.dto.interpol.initial;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class NoticeResponseDTO {
    @JsonProperty("date_of_birth")
    private String dateOfBirth;
    private List<String> nationalities;
    @JsonProperty("entity_id")
    private String entityId;
    private String forename;
    private String name;
    @JsonProperty("_links")
    private LinkResponseDTO links;
}
