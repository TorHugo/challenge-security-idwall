package com.dev.torhugo.challenge_idwall.repository;

import com.dev.torhugo.challenge_idwall.lib.data.domain.service.CrimeModel;

import java.util.List;

public interface CrimeRepository {
    /**
     * Save to database.
     *
     * @param crimeModel the crime model
     */
    void save(final CrimeModel crimeModel);

    /**
     * Find by suspect id crime model.
     *
     * @param suspectId the suspect id
     * @return the crime model
     */
    List<CrimeModel> findBySuspectId(final Long suspectId);
}
