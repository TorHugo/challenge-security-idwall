package com.dev.torhugo.challenge_idwall.repositories;

import com.dev.torhugo.challenge_idwall.lib.data.domain.MarksModel;
import com.dev.torhugo.challenge_idwall.mapper.MarksMapper;

public interface MarksRepository {
    /**
     * Save to database.
     *
     * @param marksModel the marks mapper
     */
    void save(final MarksModel marksModel);
}
