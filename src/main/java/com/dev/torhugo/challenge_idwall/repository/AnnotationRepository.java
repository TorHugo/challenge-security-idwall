package com.dev.torhugo.challenge_idwall.repository;

import com.dev.torhugo.challenge_idwall.lib.data.domain.user.AnnotationModel;

import java.util.List;

public interface AnnotationRepository {
    /**
     * Save.
     *
     * @param annotationModel the annotation model
     */
    void save(final AnnotationModel annotationModel);

    /**
     * Retrieve by user id and card name annotation model.
     *
     * @param annotationModel the annotation model
     * @return the annotation model
     */
    AnnotationModel retrieveByUserIdAndCardName(final AnnotationModel annotationModel);

    /**
     * Retrieve by user id list.
     *
     * @param userId the user id
     * @return the list
     */
    List<AnnotationModel> retrieveByUserId(final Long userId);
}
