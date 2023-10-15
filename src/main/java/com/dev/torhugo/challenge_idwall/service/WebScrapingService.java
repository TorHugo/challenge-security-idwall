package com.dev.torhugo.challenge_idwall.service;

import com.dev.torhugo.challenge_idwall.lib.data.domain.PersonModel;

public interface WebScrapingService {

    /**
     * Web scraping method object.
     *
     * @return the object
     */
    Object webScrapingMethod();

    <T> PersonModel mappingToPerson(final T response);
    PersonModel savingToDatabase(final PersonModel personModel);
}
