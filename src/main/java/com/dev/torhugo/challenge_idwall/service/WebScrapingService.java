package com.dev.torhugo.challenge_idwall.service;

import com.dev.torhugo.challenge_idwall.lib.data.domain.PersonModel;
import com.dev.torhugo.challenge_idwall.lib.data.dto.webscraping.ResponseFinal;

public interface WebScrapingService {

    /**
     * Web scraping method object.
     *
     * @return the ResponseFinal
     */
    ResponseFinal webScrapingMethod();

    /**
     * Mapping to person person model.
     *
     * @param <T>      the type parameter
     * @param response the response
     * @return the person model
     */
    <T> PersonModel mappingToPerson(final T response);

    /**
     * Saving to database person model.
     *
     * @param personModel the person model
     * @return the person model
     */
    PersonModel savingToDatabase(final PersonModel personModel);

    /**
     * Saving to database.
     *
     * @param <T>         the type parameter
     * @param personModel the person model
     * @param item        the item
     * @param image       the image
     */
    <T> void savingToDatabase(final PersonModel personModel, final T item, final T image);

    /**
     * Retrieve by external reference person model.
     *
     * @param externalReference the external reference
     * @return the person model
     */
    PersonModel retrieveByExternalReference(final String externalReference);
}
