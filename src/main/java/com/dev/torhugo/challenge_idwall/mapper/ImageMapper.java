package com.dev.torhugo.challenge_idwall.mapper;

import com.dev.torhugo.challenge_idwall.lib.data.domain.ImageModel;
import com.dev.torhugo.challenge_idwall.lib.data.domain.PersonModel;
import com.dev.torhugo.challenge_idwall.lib.data.dto.fbi.ObjectItemResponseDTO;

import java.util.List;

public interface ImageMapper {
    /**
     * Mapping to response image model.
     *
     * @param personModel the person model
     * @param response    the response
     * @return the image model
     */
    List<ImageModel> mappingToResponse(final PersonModel personModel, final ObjectItemResponseDTO response);
}
