package com.dev.torhugo.challenge_idwall.mapper.impl;

import com.dev.torhugo.challenge_idwall.lib.data.domain.service.MarksModel;
import com.dev.torhugo.challenge_idwall.lib.data.domain.service.PersonModel;
import com.dev.torhugo.challenge_idwall.lib.data.dto.fbi.ObjectItemResponseDTO;
import com.dev.torhugo.challenge_idwall.lib.data.dto.interpol.notice.ObjectInterpolResponseNoticeDTO;
import com.dev.torhugo.challenge_idwall.mapper.MarksMapper;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class MarksMapperImpl implements MarksMapper {
    @Override
    public List<MarksModel> mappingToResponse(final PersonModel personModel, final ObjectItemResponseDTO response) {
        if (Objects.isNull(response.getScarsAndMarks()))
            return null;

        return Collections.singletonList(
                MarksModel.builder()
                        .personId(personModel.getPersonId())
                        .marksDescription(response.getScarsAndMarks())
                        .build()
        );
    }

    @Override
    public List<MarksModel> mappingToResponse(final PersonModel personModel, final ObjectInterpolResponseNoticeDTO responseInterpol) {
        if (Objects.isNull(responseInterpol.getArrestWarrants()))
            return null;

        return responseInterpol.getArrestWarrants().stream().map(
                item -> MarksModel.builder()
                        .personId(personModel.getPersonId())
                        .marksDescription(item.getCharge())
                        .build())
                .collect(Collectors.toList());
    }
}
