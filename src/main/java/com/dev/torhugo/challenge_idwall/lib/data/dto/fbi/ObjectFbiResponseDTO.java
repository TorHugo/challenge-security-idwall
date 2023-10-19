package com.dev.torhugo.challenge_idwall.lib.data.dto.fbi;

import lombok.Data;

import java.util.List;

@Data
public class ObjectFbiResponseDTO {
    private Long total;
    private List<ObjectItemResponseDTO> items;
    private Integer page;
}
