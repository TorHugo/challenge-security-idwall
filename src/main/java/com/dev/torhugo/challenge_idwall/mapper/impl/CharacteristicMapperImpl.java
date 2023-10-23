package com.dev.torhugo.challenge_idwall.mapper.impl;

import com.dev.torhugo.challenge_idwall.lib.data.domain.service.CharacteristicModel;
import com.dev.torhugo.challenge_idwall.lib.data.domain.service.PersonModel;
import com.dev.torhugo.challenge_idwall.lib.data.dto.fbi.ObjectItemResponseDTO;
import com.dev.torhugo.challenge_idwall.lib.data.dto.interpol.notice.ObjectInterpolResponseNoticeDTO;
import com.dev.torhugo.challenge_idwall.mapper.CharacteristicMapper;
import org.springframework.stereotype.Component;

import static com.dev.torhugo.challenge_idwall.util.ValidateUtil.validateObjectIsNull;

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

    @Override
    public CharacteristicModel mappingToRespose(final PersonModel personModel,
                                                final ObjectInterpolResponseNoticeDTO response) {
        return CharacteristicModel.builder()
                .personId(personModel.getPersonId())
                .ageRange(null)
                .birthPlace(response.getPlaceOfBirth())
                .eyeColor(validateObjectIsNull(response.getEyesColors()) ? null : response.getEyesColors().get(0))
                .ethnicity(null)
                .height(response.getHeight())
                .weight(response.getWeight())
                .nationality(validateObjectIsNull(response.getNationalities()) ? null : response.getNationalities().get(0))
                .sex(response.getSex())
                .build();
    }
}
