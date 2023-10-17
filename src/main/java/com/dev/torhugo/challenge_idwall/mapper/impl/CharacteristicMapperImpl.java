package com.dev.torhugo.challenge_idwall.mapper.impl;

import com.dev.torhugo.challenge_idwall.lib.data.domain.CharacteristicModel;
import com.dev.torhugo.challenge_idwall.lib.data.domain.PersonModel;
import com.dev.torhugo.challenge_idwall.lib.data.dto.fbi.ObjectItemResponseDTO;
import com.dev.torhugo.challenge_idwall.mapper.CharacteristicMapper;
import org.springframework.stereotype.Component;

@Component
public class CharacteristicMapperImpl implements CharacteristicMapper {
    @Override
    public CharacteristicModel mappingToRespose(final PersonModel personModel,
                                                final ObjectItemResponseDTO response) {
        return CharacteristicModel.builder()
                .personId(personModel.getPersonId())
                .ageRange(response.getAgeRange())
                .birthPlace(response.getPlaceOfBirth())
                .eyeColor(response.getEyesRaw())
                .ethnicity(response.getRace())
                .height(response.getHeight())
                .weight(response.getWeight())
                .nationality(response.getNationality())
                .sex(response.getSex())
                .build();
    }
}
