package com.dev.torhugo.challenge_idwall.service.impl;

import com.dev.torhugo.challenge_idwall.client.HttpClientService;
import com.dev.torhugo.challenge_idwall.lib.data.domain.service.PersonModel;
import com.dev.torhugo.challenge_idwall.lib.data.dto.fbi.ObjectFbiResponseDTO;
import com.dev.torhugo.challenge_idwall.lib.data.dto.webscraping.ResponseFinal;
import com.dev.torhugo.challenge_idwall.lib.exception.impl.ResourceNotFoundException;
import com.dev.torhugo.challenge_idwall.mapper.*;
import com.dev.torhugo.challenge_idwall.repository.*;
import com.dev.torhugo.challenge_idwall.util.AgencyType;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.time.LocalDateTime;
import java.util.Objects;

import static com.dev.torhugo.challenge_idwall.util.ConstantsUtil.HOST_FBI;
import static com.dev.torhugo.challenge_idwall.util.ConstantsUtil.PATH_FBI;
import static com.dev.torhugo.challenge_idwall.util.ValidateUtil.validateEmptyList;
import static com.dev.torhugo.challenge_idwall.util.ValidateUtil.validateObjectIsNull;
import static java.lang.Thread.sleep;

@Component
@Slf4j
@AgencyType("fbi")
public class WebScrapingServiceFBI extends AbstractWebScrapingService {
    public WebScrapingServiceFBI(PersonRepository personRepository, AliasRepository aliasRepository, CharacteristicRepository characteristicRepository, CrimeRepository crimeRepository, FileRepository fileRepository, ImageRepository imageRepository, MarksRepository marksRepository, PersonMapper personMapper, AliasMapper aliasMapper, CharacteristicMapper characteristicMapper, CrimeMapper crimeMapper, FileMapper fileMapper, ImageMapper imageMapper, MarksMapper marksMapper, HttpClientService service) {
        super(personRepository, aliasRepository, characteristicRepository, crimeRepository, fileRepository, imageRepository, marksRepository, personMapper, aliasMapper, characteristicMapper, crimeMapper, fileMapper, imageMapper, marksMapper);
        this.service = service;
    }

    private final HttpClientService service;
    private Integer items = 1;

    @Override
    @Transactional
    public ResponseFinal webScrapingMethod() {
        log.info("[FBI] - Initial process web-scraping.");
        final LocalDateTime startProcess = LocalDateTime.now();
        try {
            while (true){
                log.info("[1] - PageSize: {}.", initialValue);
                final ObjectFbiResponseDTO response = requestToFBI(initialValue);
                log.info("[2] - Validating to response.");
                if (validateObjectIsNull(response)) {
                    log.info("[3] - No response.");
                    break;
                }
                if (!validateEmptyList(response.getItems())) {
                    log.info("[3] - No response.");
                    break;
                }
                log.info("[3] - Saving to database.");
                savingToResponse(response);
                log.info("[4] - Increment pageSize.");
                initialValue += 1;
                log.info("[5] - Adding sleep 2s.");
                sleep();
            }

            return ResponseFinal.builder()
                    .totalProcessItems(items)
                    .startProcess(startProcess)
                    .endProcess(LocalDateTime.now())
                    .build();
        } catch (RuntimeException e) {
            e.printStackTrace();
            throw new ResourceNotFoundException("[ERROR] An error occurred while web-scraping. Error: " + e.getMessage());
        }
    }

    private void sleep() {
        try {
            Thread.sleep(3000); // Aguarda 1 segundo (1000 milissegundos)
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private ObjectFbiResponseDTO requestToFBI(final Integer initialValue) {
        return service.initialRequestFbi(HOST_FBI, PATH_FBI, buildRequestParams(initialValue));
    }

    private void savingToResponse(final ObjectFbiResponseDTO response) {
        response.getItems().forEach(item -> {
            log.info("[3.1] - Validating exists by externalReference.");
            if (validatingExists(item.getUid())){
                log.info("[3.2] - Person aleardy exists in the database.");
                return;
            }
            log.info("[3.2] - Saving to person in the database.");
            final PersonModel personModel = super.savingToDatabase(super.mappingToPerson(item));
            log.info("[3.3] - Saving to database.");
            super.savingToDatabase(personModel, item, null);
            log.info("[3.4] - Count items process.");
            items++;
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
