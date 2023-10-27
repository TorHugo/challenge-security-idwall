package com.dev.torhugo.challenge_idwall.repository;

import com.dev.torhugo.challenge_idwall.lib.data.domain.service.ImageModel;

import java.util.List;

public interface ImageRepository {
    /**
     * Save to database.
     *
     * @param imageModel the image model
     */
    void save(final ImageModel imageModel);

    /**
     * Find by suspect id list.
     *
     * @param suspectId the suspect id
     * @return the list
     */
    List<ImageModel> findBySuspectId(final Long suspectId);
}
