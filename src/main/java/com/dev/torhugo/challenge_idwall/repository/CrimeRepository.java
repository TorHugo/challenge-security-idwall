package com.dev.torhugo.challenge_idwall.repository;

import com.dev.torhugo.challenge_idwall.lib.data.domain.service.CrimeModel;

public interface CrimeRepository {
    /**
     * Save to database.
     *
     * @param crimeModel the crime model
     */
    void save(final CrimeModel crimeModel);
}
