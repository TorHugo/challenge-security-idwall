package com.dev.torhugo.challenge_idwall.repository;

import com.dev.torhugo.challenge_idwall.lib.data.domain.service.MarksModel;

import java.util.List;

public interface MarksRepository {
    /**
     * Save to database.
     *
     * @param marksModel the marks mapper
     */
    void save(final MarksModel marksModel);

    /**
     * Find by suspect id list.
     *
     * @param suspectId the suspect id
     * @return the list
     */
    List<MarksModel> findBySuspectId(final Long suspectId);
}
