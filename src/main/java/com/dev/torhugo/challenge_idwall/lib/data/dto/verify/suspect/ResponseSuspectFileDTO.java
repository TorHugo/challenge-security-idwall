package com.dev.torhugo.challenge_idwall.lib.data.dto.verify.suspect;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

@Builder
public record ResponseSuspectFileDTO(
        @JsonProperty("language_file")
        String languageFile,
        @JsonProperty("file_uri")
        String fileUri) {
}
