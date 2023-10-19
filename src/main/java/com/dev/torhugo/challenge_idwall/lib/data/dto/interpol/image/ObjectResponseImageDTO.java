package com.dev.torhugo.challenge_idwall.lib.data.dto.interpol.image;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ObjectResponseImageDTO {
    @JsonProperty("_embedded")
    private ObjectItemResponseImageDTO object;
}
