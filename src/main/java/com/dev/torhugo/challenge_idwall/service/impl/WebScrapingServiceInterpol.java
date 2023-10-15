package com.dev.torhugo.challenge_idwall.service.impl;

import com.dev.torhugo.challenge_idwall.util.AgencyType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@AgencyType("interpol")
public class WebScrapingServiceInterpol extends AbstractWebScrapingService {
    @Override
    public Object webScrapingMethod() {
        log.info("[INTERPOL] - Initial process web-scraping.");
        return null;
    }
}