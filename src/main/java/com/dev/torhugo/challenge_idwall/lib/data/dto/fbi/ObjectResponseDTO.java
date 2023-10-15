package com.dev.torhugo.challenge_idwall.lib.data.dto.fbi;

import lombok.Data;

import java.util.List;

@Data
public class ObjectResponseDTO {
    private Long total;
    private List<ObjectItemResponseDTO> items;
    private Integer page;
}
