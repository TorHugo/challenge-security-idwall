package com.dev.torhugo.challenge_idwall.lib.data.dto.fbi.initial;

import lombok.Data;

@Data
public class ImageResponseDTO {
    private String large;
    private String caption;
    private String thumb;
    private String original;
}
