package com.dev.torhugo.challenge_idwall.mapper;

import com.dev.torhugo.challenge_idwall.lib.data.domain.PersonModel;
import com.dev.torhugo.challenge_idwall.lib.data.dto.fbi.ObjectItemResponseDTO;

public interface PersonMapper {
    /**
     * Mapper to model person model.
     *
     * @param item the item
     * @return the person model
     */
    PersonModel mapperToModel(final ObjectItemResponseDTO item);
}
