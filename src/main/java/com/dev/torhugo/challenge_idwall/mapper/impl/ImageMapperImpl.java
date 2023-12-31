package com.dev.torhugo.challenge_idwall.mapper.impl;

import com.dev.torhugo.challenge_idwall.lib.data.domain.service.ImageModel;
import com.dev.torhugo.challenge_idwall.lib.data.domain.service.PersonModel;
import com.dev.torhugo.challenge_idwall.lib.data.dto.fbi.ObjectItemResponseDTO;
import com.dev.torhugo.challenge_idwall.lib.data.dto.interpol.image.ObjectResponseImageDTO;
import com.dev.torhugo.challenge_idwall.mapper.ImageMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ImageMapperImpl implements ImageMapper {
    @Override
    public List<ImageModel> mappingToResponse(final PersonModel personModel, final ObjectItemResponseDTO response) {
        if (response.getImages().isEmpty())
            return null;


        return response.getImages().stream().map(
                item -> ImageModel.builder()
                        .personId(personModel.getPersonId())
                        .externalUri(item.getThumb())
                        .imageCaption(item.getCaption())
                        .build())
                .collect(Collectors.toList());
    }

    @Override
    public List<ImageModel> mappingToResponse(final PersonModel personModel, final ObjectResponseImageDTO image) {
        if (image.getObject().getImages().isEmpty())
            return null;

        return image.getObject().getImages().stream().map(
                        item -> ImageModel.builder()
                                .personId(personModel.getPersonId())
                                .externalUri(item.getLink().getSelf().getHref())
                                .imageCaption(item.getPictureId())
                                .build())
                .collect(Collectors.toList());
    }
}
