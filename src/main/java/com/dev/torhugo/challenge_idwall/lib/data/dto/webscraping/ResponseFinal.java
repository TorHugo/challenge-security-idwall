package com.dev.torhugo.challenge_idwall.lib.data.dto.webscraping;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record ResponseFinal(
        @JsonProperty("total_process_items")
        Integer totalProcessItems,
        @JsonProperty("start_process")
        @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss", timezone = "UTC")
        LocalDateTime startProcess,
        @JsonProperty("end_process")
        @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss", timezone = "UTC")
        LocalDateTime endProcess
) {
}
