package com.dev.torhugo.challenge_idwall.repository;

import com.dev.torhugo.challenge_idwall.lib.data.domain.service.AliasModel;

import java.util.List;

public interface AliasRepository {

    /**
     * Save to Database.
     *
     * @param alias the AliasModel
     */
    void save(final AliasModel alias);

    /**
     * Find by suspect id list.
     *
     * @param suspectId the suspect id
     * @return the list
     */
    List<AliasModel> findBySuspectId(final Long suspectId);
}
