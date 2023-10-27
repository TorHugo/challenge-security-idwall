package com.dev.torhugo.challenge_idwall.mapper.impl;

import com.dev.torhugo.challenge_idwall.lib.data.domain.user.AnnotationModel;
import com.dev.torhugo.challenge_idwall.lib.data.dto.annotation.RequestAnnotationDTO;
import com.dev.torhugo.challenge_idwall.lib.data.dto.annotation.ResponseAnnotationInfoDTO;
import com.dev.torhugo.challenge_idwall.lib.data.dto.annotation.ResponseAnnotationSuccessDTO;
import com.dev.torhugo.challenge_idwall.lib.data.dto.annotation.ResponseBaseAnnotationDTO;
import com.dev.torhugo.challenge_idwall.mapper.AnnotationMapper;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
public class AnnotationMapperImpl implements AnnotationMapper {
    @Override
    public AnnotationModel mappingToModel(final RequestAnnotationDTO request) {
        return AnnotationModel.builder()
                .userId(request.userId())
                .cardName(request.cardName())
                .cardDescription(request.cardInfo().description())
                .cardEmail(request.cardInfo().email())
                .cardPhone(request.cardInfo().phoneNumber())
                .cardAddress(request.cardInfo().address())
                .inActive(Boolean.TRUE)
                .build();
    }

    @Override
    public ResponseAnnotationSuccessDTO mappingToResponse(final AnnotationModel annotationSaved) {
        return ResponseAnnotationSuccessDTO.builder()
                .userId(annotationSaved.getUserId())
                .annotationId(annotationSaved.getAnnotationId())
                .createAt(annotationSaved.getCreatAt())
                .build();
    }

    @Override
    public ResponseBaseAnnotationDTO mappingToResponseAll(final List<AnnotationModel> annotations, final Long userId) {
        return ResponseBaseAnnotationDTO.builder()
                .userId(userId)
                .cards(mappingToCards(annotations))
                .build();
    }

    private List<ResponseAnnotationInfoDTO> mappingToCards(final List<AnnotationModel> annotations) {
        return annotations.stream().map(annotation ->
                ResponseAnnotationInfoDTO.builder()
                        .annotationId(annotation.getAnnotationId())
                        .cardName(annotation.getCardName())
                        .cardDescription(annotation.getCardDescription())
                        .cardEmail(annotation.getCardEmail())
                        .cardAddress(annotation.getCardAddress())
                        .cardPhoneNumber(annotation.getCardPhone())
                        .inActive(annotation.getInActive())
                        .createAt(annotation.getCreatAt())
                        .build()).toList();
    }
}
