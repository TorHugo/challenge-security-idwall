package com.dev.torhugo.challenge_idwall.mapper;

import com.dev.torhugo.challenge_idwall.lib.data.domain.service.FileModel;
import com.dev.torhugo.challenge_idwall.lib.data.domain.service.PersonModel;
import com.dev.torhugo.challenge_idwall.lib.data.dto.fbi.ObjectItemResponseDTO;

import java.util.List;

public interface FileMapper {

    /**
     * Mapping to response file model.
     *
     * @param personModel the person model
     * @param response    the response
     * @return the file model
     */
    List<FileModel> mappingToResponse(final PersonModel personModel, final ObjectItemResponseDTO response);
}
