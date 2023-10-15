package com.dev.torhugo.challenge_idwall.service.factory;

import com.dev.torhugo.challenge_idwall.service.WebScrapingService;

public interface WebScrapingFactory {

    /**
     * Gets processor.
     * Expected agency: fbi or interpol.
     *
     * @param agency the agency
     * @return the processor
     */
    WebScrapingService getProcessor(final String agency);
}
