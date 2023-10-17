package com.dev.torhugo.challenge_idwall.mapper;

import com.dev.torhugo.challenge_idwall.lib.data.domain.CharacteristicModel;
import com.dev.torhugo.challenge_idwall.lib.data.domain.PersonModel;
import com.dev.torhugo.challenge_idwall.lib.data.dto.fbi.ObjectItemResponseDTO;

public interface CharacteristicMapper {

    /**
     * Mapping to respose characteristic model.
     *
     * @param personModel the person model
     * @param response    the response
     * @return the characteristic model
     */
    CharacteristicModel mappingToRespose(final PersonModel personModel, final ObjectItemResponseDTO response);
}
