package com.dev.torhugo.challenge_idwall.lib.data.dto.interpol.initial;

import com.dev.torhugo.challenge_idwall.lib.data.dto.interpol.link.ImageResponseDTO;
import com.dev.torhugo.challenge_idwall.lib.data.dto.interpol.link.SelfResponseDTO;
import com.dev.torhugo.challenge_idwall.lib.data.dto.interpol.link.ThumbnailResponseDTO;
import lombok.Data;

@Data
public class LinkResponseDTO {
    private SelfResponseDTO self;
    private ImageResponseDTO images;
    private ThumbnailResponseDTO thumbnail;
}
