package com.dev.torhugo.challenge_idwall.lib.data.dto.interpol;

import com.dev.torhugo.challenge_idwall.lib.data.dto.interpol.initial.ExternalHrefDTO;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ObjectInterpolResponseDTO {
    private Integer total;
    @JsonProperty("_embedded")
    private ObjectItemResponseDTO embedded;
    @JsonProperty("_links")
    private ExternalHrefDTO links;
}
