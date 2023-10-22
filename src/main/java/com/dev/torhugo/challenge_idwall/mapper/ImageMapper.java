package com.dev.torhugo.challenge_idwall.mapper;

import com.dev.torhugo.challenge_idwall.lib.data.domain.service.ImageModel;
import com.dev.torhugo.challenge_idwall.lib.data.domain.service.PersonModel;
import com.dev.torhugo.challenge_idwall.lib.data.dto.fbi.ObjectItemResponseDTO;
import com.dev.torhugo.challenge_idwall.lib.data.dto.interpol.image.ObjectResponseImageDTO;

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

    /**
     * Mapping to response list.
     *
     * @param personModel the person model
     * @param image       the image
     * @return the list
     */
    List<ImageModel> mappingToResponse(final PersonModel personModel, final ObjectResponseImageDTO image);
}
