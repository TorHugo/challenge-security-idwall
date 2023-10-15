package com.dev.torhugo.challenge_idwall.service.factory.impl;

import com.dev.torhugo.challenge_idwall.lib.exception.impl.ResourceNotFoundException;
import com.dev.torhugo.challenge_idwall.service.WebScrapingService;
import com.dev.torhugo.challenge_idwall.service.factory.WebScrapingFactory;
import com.dev.torhugo.challenge_idwall.service.impl.WebScrapingServiceFBI;
import com.dev.torhugo.challenge_idwall.service.impl.WebScrapingServiceInterpol;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class WebScrapingFactoryImpl implements WebScrapingFactory {
    private final WebScrapingServiceFBI webScrapingServiceFBI;
    private final WebScrapingServiceInterpol webScrapingServiceInterpol;

    @Override
    public WebScrapingService getProcessor(final String agency) {
        WebScrapingService processor;
        return switch (agency) {
            case "fbi" -> {
                processor = webScrapingServiceFBI;
                yield processor;
            }
            case "interpol" -> {
                processor = webScrapingServiceInterpol;
                yield processor;
            }
            default -> throw new ResourceNotFoundException("Agency not found!.");
        };
    }
}

