package com.dev.torhugo.challenge_idwall.mapper.impl;

import com.dev.torhugo.challenge_idwall.lib.data.domain.service.AliasModel;
import com.dev.torhugo.challenge_idwall.lib.data.domain.service.PersonModel;
import com.dev.torhugo.challenge_idwall.lib.data.dto.fbi.ObjectItemResponseDTO;
import com.dev.torhugo.challenge_idwall.mapper.AliasMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class AliasMapperImpl implements AliasMapper {
    @Override
    public List<AliasModel> mappingToResponse(final PersonModel personModel,
                                              final ObjectItemResponseDTO response) {
        if (Objects.isNull(response.getAliases()) || response.getAliases().isEmpty())
            return null;

        return response.getAliases().stream()
                .map(item -> AliasModel.builder()
                        .personId(personModel.getPersonId())
                        .aliasDescription(item)
                        .build())
                .collect(Collectors.toList());
    }
}
