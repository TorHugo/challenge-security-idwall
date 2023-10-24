package com.dev.torhugo.challenge_idwall.repository;

import com.dev.torhugo.challenge_idwall.lib.data.domain.service.ImageModel;

public interface ImageRepository {
    /**
     * Save to database.
     *
     * @param imageModel the image model
     */
    void save(final ImageModel imageModel);
}
