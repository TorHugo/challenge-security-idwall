package com.dev.torhugo.challenge_idwall.repository;

import com.dev.torhugo.challenge_idwall.lib.data.domain.service.CharacteristicModel;

public interface CharacteristicRepository {
    /**
     * Save to database.
     *
     * @param characteristicModel the characteristic model
     */
    void save(final CharacteristicModel characteristicModel);

    /**
     * Find by suspect id characteristic model.
     *
     * @param suspectId the suspect id
     * @return the characteristic model
     */
    CharacteristicModel findBySuspectId(final Long suspectId);
}
