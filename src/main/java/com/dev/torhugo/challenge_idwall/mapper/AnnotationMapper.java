package com.dev.torhugo.challenge_idwall.mapper;

import com.dev.torhugo.challenge_idwall.lib.data.domain.user.AnnotationModel;
import com.dev.torhugo.challenge_idwall.lib.data.dto.annotation.RequestAnnotationDTO;
import com.dev.torhugo.challenge_idwall.lib.data.dto.annotation.ResponseAnnotationSuccessDTO;
import com.dev.torhugo.challenge_idwall.lib.data.dto.annotation.ResponseBaseAnnotationDTO;

import java.util.List;

public interface AnnotationMapper {
    /**
     * Mapping to model annotation model.
     *
     * @param request the request
     * @return the annotation model
     */
    AnnotationModel mappingToModel(final RequestAnnotationDTO request);

    /**
     * Mapping to response response annotation success dto.
     *
     * @param annotationSaved the annotation saved
     * @return the response annotation success dto
     */
    ResponseAnnotationSuccessDTO mappingToResponse(final AnnotationModel annotationSaved);

    /**
     * Mapping to response all response base annotation dto.
     *
     * @param annotations the annotations
     * @param userId the userId
     * @return the response base annotation dto
     */
    ResponseBaseAnnotationDTO mappingToResponseAll(final List<AnnotationModel> annotations, final Long userId);
}
