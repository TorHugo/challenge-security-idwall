package com.dev.torhugo.challenge_idwall.service.impl;

import com.dev.torhugo.challenge_idwall.client.HttpClientService;
import com.dev.torhugo.challenge_idwall.lib.data.domain.PersonModel;
import com.dev.torhugo.challenge_idwall.lib.data.dto.fbi.ObjectItemResponseDTO;
import com.dev.torhugo.challenge_idwall.lib.data.dto.fbi.ObjectResponseDTO;
import com.dev.torhugo.challenge_idwall.repositories.PersonRepository;
import com.dev.torhugo.challenge_idwall.service.WebScrapingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public abstract class AbstractWebScrapingService implements WebScrapingService {
    public static final String HOST_FBI = "https://api.fbi.gov/";
    public static final String PATH_FBI = "@wanted";
    public static Integer INITIAL_VALUE = 1;

    private final PersonRepository personRepository;

    @Override
    public <T> PersonModel mappingToPerson(final T response) {
        if (response instanceof ObjectItemResponseDTO item){
            return PersonModel.builder()
                    .criminalClassification(item.getPersonClassification())
                    .datePublication(item.getPublication())
                    .personDescription(item.getDescription())
                    .titlePublication(item.getTitle())
                    .build();
        }
        return null;
    }

    @Override
    public PersonModel savingToDatabase(final PersonModel personModel) {
        personRepository.saving(personModel);
        return personRepository.retrieveByExternalReference(personModel.getExternalId());
    }
}
