package com.dev.torhugo.challenge_idwall.service.impl;

import com.dev.torhugo.challenge_idwall.client.HttpClientService;
import com.dev.torhugo.challenge_idwall.lib.data.domain.PersonModel;
import com.dev.torhugo.challenge_idwall.lib.data.dto.fbi.ObjectResponseDTO;
import com.dev.torhugo.challenge_idwall.lib.exception.impl.ResourceNotFoundException;
import com.dev.torhugo.challenge_idwall.mapper.PersonMapper;
import com.dev.torhugo.challenge_idwall.repositories.PersonRepository;
import com.dev.torhugo.challenge_idwall.util.AgencyType;
import lombok.experimental.SuperBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import static com.dev.torhugo.challenge_idwall.util.ConstantsUtil.HOST_FBI;
import static com.dev.torhugo.challenge_idwall.util.ConstantsUtil.PATH_FBI;

@Component
@Slf4j
@AgencyType("fbi")
public class WebScrapingServiceFBI extends AbstractWebScrapingService {
    private final HttpClientService service;
    public WebScrapingServiceFBI(PersonRepository personRepository,
                                 PersonMapper personMapper,
                                 HttpClientService service) {
        super(personRepository, personMapper);
        this.service = service;
    }

    @Override
    public Object webScrapingMethod() {
        log.info("[FBI] - Initial process web-scraping.");
        try {
            while (true){
                log.info("[1] - PageSize: {}.", initialValue);
                final ObjectResponseDTO response = requestToFBI(initialValue);
                log.info("[2] - Validating to response.");
                if (response.getItems().isEmpty())
                    break;
                log.info("[3] - Saving to database.");
                savingToResponse(response);
                log.info("[4] - Increment pageSize.");
                initialValue += 1;
            }

            return initialValue;
        } catch (RuntimeException e) {
            throw new ResourceNotFoundException("[ERROR] An error occurred while converting the response. Error: " + e.getMessage());
        }
    }

    private ObjectResponseDTO requestToFBI(final Integer initialValue) {
        return service.requestToFBI(HOST_FBI, PATH_FBI, buildRequestParams(initialValue));
    }

    private void savingToResponse(final ObjectResponseDTO response) {
        response.getItems().forEach(item -> {
            final PersonModel personModel = super.savingToDatabase(super.mappingToPerson(item));
        });
    }

    private MultiValueMap<String, String> buildRequestParams(final Integer pageSize){
        MultiValueMap<String, String> requestParams = new LinkedMultiValueMap<>();
        requestParams.add("pageSize", "20");
        requestParams.add("page", pageSize.toString());
        return requestParams;
    }
}
