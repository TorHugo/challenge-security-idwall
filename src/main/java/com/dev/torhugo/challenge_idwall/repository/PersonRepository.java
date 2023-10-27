package com.dev.torhugo.challenge_idwall.repository;

import com.dev.torhugo.challenge_idwall.lib.data.domain.service.PersonModel;

import java.util.List;

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


    /**
     * Find all by suspect involvement AML.
     *
     * @return {@link PersonModel}
     */
    List<PersonModel> findAllBySuspectAml();

    /**
     * Retrieve by suspect id person model.
     *
     * @param suspectId the suspect id
     * @return the person model
     */
    PersonModel retrieveBySuspectId(final Long suspectId);

    /**
     * Retrieve by suspect name person model.
     *
     * @param name the name
     * @return the person model
     */
    List<PersonModel> retrieveBySuspectName(final String name);
}
