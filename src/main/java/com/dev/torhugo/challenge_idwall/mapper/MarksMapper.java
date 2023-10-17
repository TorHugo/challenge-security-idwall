package com.dev.torhugo.challenge_idwall.mapper;

import com.dev.torhugo.challenge_idwall.lib.data.domain.MarksModel;
import com.dev.torhugo.challenge_idwall.lib.data.domain.PersonModel;
import com.dev.torhugo.challenge_idwall.lib.data.dto.fbi.ObjectItemResponseDTO;

import java.util.List;

public interface MarksMapper {
    /**
     * Mapping to response marks model.
     *
     * @param personModel the person model
     * @param response    the response
     * @return the marks model
     */
    List<MarksModel> mappingToResponse(final PersonModel personModel, final ObjectItemResponseDTO response);
}
