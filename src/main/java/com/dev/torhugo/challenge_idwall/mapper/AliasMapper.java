package com.dev.torhugo.challenge_idwall.mapper;

import com.dev.torhugo.challenge_idwall.lib.data.domain.service.AliasModel;
import com.dev.torhugo.challenge_idwall.lib.data.domain.service.PersonModel;
import com.dev.torhugo.challenge_idwall.lib.data.dto.fbi.ObjectItemResponseDTO;

import java.util.List;

public interface AliasMapper {
    /**
     * Mapping to response alias model.
     *
     * @param personModel the person model
     * @param response    the response
     * @return the alias model
     */
    List<AliasModel> mappingToResponse(final PersonModel personModel, final ObjectItemResponseDTO response);

}
