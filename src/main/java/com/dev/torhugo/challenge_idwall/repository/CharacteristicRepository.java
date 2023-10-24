package com.dev.torhugo.challenge_idwall.repository;

import com.dev.torhugo.challenge_idwall.lib.data.domain.service.CharacteristicModel;

public interface CharacteristicRepository {
    /**
     * Save to database.
     *
     * @param characteristicModel the characteristic model
     */
    void save(final CharacteristicModel characteristicModel);
}
