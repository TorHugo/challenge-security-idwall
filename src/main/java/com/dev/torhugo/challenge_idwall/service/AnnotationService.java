package com.dev.torhugo.challenge_idwall.service;

import com.dev.torhugo.challenge_idwall.lib.data.dto.annotation.RequestAnnotationDTO;
import com.dev.torhugo.challenge_idwall.lib.data.dto.annotation.ResponseAnnotationSuccessDTO;
import com.dev.torhugo.challenge_idwall.lib.data.dto.annotation.ResponseBaseAnnotationDTO;

public interface AnnotationService {
    /**
     * Create annotation response annotation success dto.
     *
     * @param request the user id
     * @return the response annotation success dto
     */
    ResponseAnnotationSuccessDTO createAnnotation(final RequestAnnotationDTO request);

    /**
     * Find all by user id response base annotation dto.
     *
     * @param userId the user id
     * @return the response base annotation dto
     */
    ResponseBaseAnnotationDTO findAllByUserId(final Long userId);
}
