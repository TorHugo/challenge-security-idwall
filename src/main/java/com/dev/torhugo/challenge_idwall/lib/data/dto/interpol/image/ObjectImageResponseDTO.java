package com.dev.torhugo.challenge_idwall.lib.data.dto.interpol.image;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ObjectImageResponseDTO {
    @JsonProperty("picture_id")
    private String pictureId;
    @JsonProperty("_links")
    private ObjectImageLinkResponse link;
}
