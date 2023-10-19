package com.dev.torhugo.challenge_idwall.lib.data.dto.interpol;

import com.dev.torhugo.challenge_idwall.lib.data.dto.interpol.initial.NoticeResponseDTO;
import lombok.Data;

import java.util.List;

@Data
public class ObjectItemResponseDTO {
    private List<NoticeResponseDTO> notices;
}
