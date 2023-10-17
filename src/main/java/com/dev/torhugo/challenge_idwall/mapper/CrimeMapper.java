package com.dev.torhugo.challenge_idwall.mapper;

import com.dev.torhugo.challenge_idwall.lib.data.domain.CrimeModel;
import com.dev.torhugo.challenge_idwall.lib.data.domain.PersonModel;
import com.dev.torhugo.challenge_idwall.lib.data.dto.fbi.ObjectItemResponseDTO;

import java.util.List;

public interface CrimeMapper {
    /**
     * Mapping to response crime model.
     *
     * @param personModel the person model
     * @param response    the response
     * @return the crime model
     */
    List<CrimeModel> mappingToResponse(final PersonModel personModel, final ObjectItemResponseDTO response);
}
