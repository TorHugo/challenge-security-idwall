package com.dev.torhugo.challenge_idwall.repositories;

import com.dev.torhugo.challenge_idwall.lib.data.domain.service.MarksModel;

public interface MarksRepository {
    /**
     * Save to database.
     *
     * @param marksModel the marks mapper
     */
    void save(final MarksModel marksModel);
}
