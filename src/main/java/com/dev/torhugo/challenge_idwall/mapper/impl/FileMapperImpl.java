package com.dev.torhugo.challenge_idwall.mapper.impl;

import com.dev.torhugo.challenge_idwall.lib.data.domain.FileModel;
import com.dev.torhugo.challenge_idwall.lib.data.domain.PersonModel;
import com.dev.torhugo.challenge_idwall.lib.data.dto.fbi.ObjectItemResponseDTO;
import com.dev.torhugo.challenge_idwall.mapper.FileMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class FileMapperImpl implements FileMapper {
    @Override
    public List<FileModel> mappingToResponse(final PersonModel personModel, final ObjectItemResponseDTO response) {
        if (response.getFiles().isEmpty())
            return null;

        return response.getFiles().stream().map(
                item -> FileModel.builder()
                        .personId(personModel.getPersonId())
                        .externalUri(item.getUrl())
                        .languageFile(item.getName())
                        .build()
                ).collect(Collectors.toList());
    }
}
