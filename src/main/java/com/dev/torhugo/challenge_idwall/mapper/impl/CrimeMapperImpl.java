package com.dev.torhugo.challenge_idwall.mapper.impl;

import com.dev.torhugo.challenge_idwall.lib.data.domain.CrimeModel;
import com.dev.torhugo.challenge_idwall.lib.data.domain.PersonModel;
import com.dev.torhugo.challenge_idwall.lib.data.dto.fbi.ObjectItemResponseDTO;
import com.dev.torhugo.challenge_idwall.lib.data.dto.interpol.notice.ObjectInterpolResponseNoticeDTO;
import com.dev.torhugo.challenge_idwall.mapper.CrimeMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class CrimeMapperImpl implements CrimeMapper {
    @Override
    public List<CrimeModel> mappingToResponse(final PersonModel personModel,
                                              final ObjectItemResponseDTO response) {
        if (response.getSubjects().isEmpty())
            return null;

        return response.getSubjects().stream().map(
                item -> CrimeModel.builder()
                        .personId(personModel.getPersonId())
                        .crimeDescription(item)
                        .build()
        ).collect(Collectors.toList());
    }

    @Override
    public List<CrimeModel> mappingToResponse(final PersonModel personModel,
                                              final ObjectInterpolResponseNoticeDTO responseInterpol) {
        return null;
    }
}
