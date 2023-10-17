package com.dev.torhugo.challenge_idwall.repositories;

import com.dev.torhugo.challenge_idwall.lib.data.domain.ImageModel;

public interface ImageRepository {
    /**
     * Save to database.
     *
     * @param imageModel the image model
     */
    void save(final ImageModel imageModel);
}
