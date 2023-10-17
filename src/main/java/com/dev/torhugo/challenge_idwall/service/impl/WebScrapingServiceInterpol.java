package com.dev.torhugo.challenge_idwall.service.impl;

import com.dev.torhugo.challenge_idwall.client.HttpClientService;
import com.dev.torhugo.challenge_idwall.mapper.*;
import com.dev.torhugo.challenge_idwall.repositories.*;
import com.dev.torhugo.challenge_idwall.util.AgencyType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@AgencyType("interpol")
public class WebScrapingServiceInterpol extends AbstractWebScrapingService {
    public WebScrapingServiceInterpol(PersonRepository personRepository, AliasRepository aliasRepository, CharacteristicRepository characteristicRepository, CrimeRepository crimeRepository, FileRepository fileRepository, ImageRepository imageRepository, MarksRepository marksRepository, PersonMapper personMapper, AliasMapper aliasMapper, CharacteristicMapper characteristicMapper, CrimeMapper crimeMapper, FileMapper fileMapper, ImageMapper imageMapper, MarksMapper marksMapper, HttpClientService service) {
        super(personRepository, aliasRepository, characteristicRepository, crimeRepository, fileRepository, imageRepository, marksRepository, personMapper, aliasMapper, characteristicMapper, crimeMapper, fileMapper, imageMapper, marksMapper);
        this.service = service;
    }

    private final HttpClientService service;

    @Override
    public Object webScrapingMethod() {
        log.info("[INTERPOL] - Initial process web-scraping.");
        return null;
    }
}
