package com.dev.torhugo.challenge_idwall.service.impl;

import com.dev.torhugo.challenge_idwall.client.HttpClientService;
import com.dev.torhugo.challenge_idwall.lib.data.domain.PersonModel;
import com.dev.torhugo.challenge_idwall.lib.data.dto.fbi.ObjectResponseDTO;
import com.dev.torhugo.challenge_idwall.lib.exception.impl.ResourceNotFoundException;
import com.dev.torhugo.challenge_idwall.mapper.*;
import com.dev.torhugo.challenge_idwall.repositories.*;
import com.dev.torhugo.challenge_idwall.util.AgencyType;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.util.Objects;

import static com.dev.torhugo.challenge_idwall.util.ConstantsUtil.HOST_FBI;
import static com.dev.torhugo.challenge_idwall.util.ConstantsUtil.PATH_FBI;

@Component
@Slf4j
@AgencyType("fbi")
public class WebScrapingServiceFBI extends AbstractWebScrapingService {
    public WebScrapingServiceFBI(PersonRepository personRepository, AliasRepository aliasRepository, CharacteristicRepository characteristicRepository, CrimeRepository crimeRepository, FileRepository fileRepository, ImageRepository imageRepository, MarksRepository marksRepository, PersonMapper personMapper, AliasMapper aliasMapper, CharacteristicMapper characteristicMapper, CrimeMapper crimeMapper, FileMapper fileMapper, ImageMapper imageMapper, MarksMapper marksMapper, HttpClientService service) {
        super(personRepository, aliasRepository, characteristicRepository, crimeRepository, fileRepository, imageRepository, marksRepository, personMapper, aliasMapper, characteristicMapper, crimeMapper, fileMapper, imageMapper, marksMapper);
        this.service = service;
    }

    private final HttpClientService service;

    @Override
    @Transactional
    public Object webScrapingMethod() {
        log.info("[FBI] - Initial process web-scraping.");
        try {
            while (true){
                log.info("[1] - PageSize: {}.", initialValue);
                final ObjectResponseDTO response = requestToFBI(initialValue);
                log.info("[2] - Validating to response.");
                if (response.getItems().isEmpty()){
                    log.info("[3] - No response.");
                    break;
                }
                log.info("[3] - Saving to database.");
                savingToResponse(response);
                log.info("[4] - Increment pageSize.");
                initialValue += 1;
            }

            return initialValue;
        } catch (RuntimeException e) {
            e.printStackTrace();
            throw new ResourceNotFoundException("[ERROR] An error occurred while web-scraping. Error: " + e.getMessage());
        }
    }

    private ObjectResponseDTO requestToFBI(final Integer initialValue) {
        return service.requestToFBI(HOST_FBI, PATH_FBI, buildRequestParams(initialValue));
    }

    private void savingToResponse(final ObjectResponseDTO response) {
        response.getItems().forEach(item -> {
            log.info("[3.1] - Validating exists by externalReference.");
            if (validatingExists(item.getUid())){
                log.info("[3.2] - Person aleardy exists in the database.");
                return;
            }
            log.info("[3.2] - Saving to person in the database.");
            final PersonModel personModel = super.savingToDatabase(super.mappingToPerson(item));
            log.info("[3.3] - Saving to database.");
            super.savingToDatabase(personModel, item);
        });
    }

    private boolean validatingExists(final String uid) {
        final PersonModel personModel = super.retrieveByExternalReference(uid);
        return Objects.nonNull(personModel);
    }

    private MultiValueMap<String, String> buildRequestParams(final Integer pageSize){
        MultiValueMap<String, String> requestParams = new LinkedMultiValueMap<>();
        requestParams.add("pageSize", "20");
        requestParams.add("page", pageSize.toString());
        return requestParams;
    }
}
