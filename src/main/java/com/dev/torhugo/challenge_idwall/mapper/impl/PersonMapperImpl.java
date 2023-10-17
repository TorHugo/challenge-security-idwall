package com.dev.torhugo.challenge_idwall.mapper.impl;

import com.dev.torhugo.challenge_idwall.lib.data.domain.PersonModel;
import com.dev.torhugo.challenge_idwall.lib.data.dto.fbi.ObjectItemResponseDTO;
import com.dev.torhugo.challenge_idwall.mapper.PersonMapper;
import org.springframework.stereotype.Component;

@Component
public class PersonMapperImpl implements PersonMapper {
    @Override
    public PersonModel mapperToModel(final ObjectItemResponseDTO item) {
        return PersonModel.builder()
                .criminalClassification(item.getPersonClassification())
                .datePublication(item.getPublication())
                .personDescription(item.getDescription())
                .titlePublication(item.getTitle())
                .externalId(item.getUid())
                .inActive(Boolean.TRUE)
                .build();
    }
}
