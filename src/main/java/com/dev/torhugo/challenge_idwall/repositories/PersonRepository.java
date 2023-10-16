package com.dev.torhugo.challenge_idwall.repositories;

import com.dev.torhugo.challenge_idwall.lib.data.domain.PersonModel;

public interface PersonRepository {
    /**
     * Saving.
     *
     * @param personModel the person model
     */
    void saving(final PersonModel personModel);

    /**
     * Retrieve by external reference person model.
     *
     * @param externalId the external id
     * @return the person model
     */
    PersonModel retrieveByExternalReference(final String externalId);
}
