package com.dev.torhugo.challenge_idwall.mapper.impl;

import com.dev.torhugo.challenge_idwall.lib.data.domain.MarksModel;
import com.dev.torhugo.challenge_idwall.lib.data.domain.PersonModel;
import com.dev.torhugo.challenge_idwall.lib.data.dto.fbi.ObjectItemResponseDTO;
import com.dev.torhugo.challenge_idwall.mapper.MarksMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

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
}
