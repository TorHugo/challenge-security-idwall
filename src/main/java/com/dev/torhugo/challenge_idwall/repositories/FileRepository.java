package com.dev.torhugo.challenge_idwall.repositories;

import com.dev.torhugo.challenge_idwall.lib.data.domain.service.FileModel;

public interface FileRepository {
    /**
     * Save to database.
     *
     * @param fileModel the file model
     */
    void save(final FileModel fileModel);
}
