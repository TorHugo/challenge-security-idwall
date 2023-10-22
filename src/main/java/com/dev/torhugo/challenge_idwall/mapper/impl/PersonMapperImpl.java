package com.dev.torhugo.challenge_idwall.mapper.impl;

import com.dev.torhugo.challenge_idwall.lib.data.domain.service.PersonModel;
import com.dev.torhugo.challenge_idwall.lib.data.dto.fbi.ObjectItemResponseDTO;
import com.dev.torhugo.challenge_idwall.lib.data.dto.interpol.initial.NoticeResponseDTO;
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

    @Override
    public PersonModel mapperToModel(final NoticeResponseDTO notice) {
        return PersonModel.builder()
                .criminalClassification("red")
                .datePublication(null)
                .personDescription(notice.getName().concat(" ").concat(notice.getForename()))
                .titlePublication(notice.getName().concat(" ").concat(notice.getForename()))
                .externalId(notice.getEntityId())
                .inActive(Boolean.TRUE)
                .build();
    }
}
