package com.dev.torhugo.challenge_idwall.lib.data.dto.verify.suspect;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

@Builder
public record ResponseSuspectImageDTO(String caption,
                                      @JsonProperty("image_uri")
                                      String imageUri) {
}
