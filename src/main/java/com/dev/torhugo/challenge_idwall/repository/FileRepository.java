package com.dev.torhugo.challenge_idwall.repository;

import com.dev.torhugo.challenge_idwall.lib.data.domain.service.FileModel;

import java.util.List;

public interface FileRepository {
    /**
     * Save to database.
     *
     * @param fileModel the file model
     */
    void save(final FileModel fileModel);

    /**
     * Find by suspect id list.
     *
     * @param suspectId the suspect id
     * @return the list
     */
    List<FileModel> findBySuspectId(final Long suspectId);
}
