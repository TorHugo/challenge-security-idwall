package com.dev.torhugo.challenge_idwall.mapper.impl;

import com.dev.torhugo.challenge_idwall.lib.data.domain.service.PersonModel;
import com.dev.torhugo.challenge_idwall.lib.data.dto.fbi.ObjectItemResponseDTO;
import com.dev.torhugo.challenge_idwall.lib.data.dto.interpol.initial.NoticeResponseDTO;
import com.dev.torhugo.challenge_idwall.lib.data.dto.verify.BaseLinkSuspectDTO;
import com.dev.torhugo.challenge_idwall.lib.data.dto.verify.BaseSuspectDTO;
import com.dev.torhugo.challenge_idwall.lib.data.dto.verify.ResponseVerifyAmlDTO;
import com.dev.torhugo.challenge_idwall.mapper.PersonMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.spi.LocaleServiceProvider;
import java.util.stream.Collectors;

import static com.dev.torhugo.challenge_idwall.util.ConstantsUtil.PATH_FIND_SUSPECT_BY_ID;

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

    @Override
    public ResponseVerifyAmlDTO mapperToResponseAllAml(final List<PersonModel> lsSuspect) {
        return ResponseVerifyAmlDTO.builder()
                .items((long) lsSuspect.size())
                .suspects(lsSuspect.stream()
                        .map(this::buildBaseSuspect)
                        .toList())
                .build();
    }

    private BaseSuspectDTO buildBaseSuspect(final PersonModel suspect) {
        return BaseSuspectDTO.builder()
                .personId(suspect.getPersonId())
                .name(suspect.getTitlePublication())
                .description(suspect.getPersonDescription())
                .criminalClassification(suspect.getCriminalClassification())
                .datePublication(suspect.getDatePublication())
                .links(Collections.singletonList(buildBaseLink(suspect.getPersonId())))
                .build();
    }

    private BaseLinkSuspectDTO buildBaseLink(final Long personId) {
        return BaseLinkSuspectDTO.builder()
                .path(PATH_FIND_SUSPECT_BY_ID.concat(personId.toString()))
                .method("[GET]")
                .build();
    }
}
