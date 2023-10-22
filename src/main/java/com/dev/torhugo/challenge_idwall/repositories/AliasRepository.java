package com.dev.torhugo.challenge_idwall.repositories;

import com.dev.torhugo.challenge_idwall.lib.data.domain.service.AliasModel;

public interface AliasRepository {

    /**
     * Save to Database.
     *
     * @param alias the AliasModel
     */
    void save(final AliasModel alias);
}
