package com.dev.torhugo.challenge_idwall.service.impl;

import com.dev.torhugo.challenge_idwall.client.HttpClientService;
import com.dev.torhugo.challenge_idwall.lib.data.domain.PersonModel;
import com.dev.torhugo.challenge_idwall.lib.data.dto.fbi.ObjectResponseDTO;
import com.dev.torhugo.challenge_idwall.lib.exception.impl.ResourceNotFoundException;
import com.dev.torhugo.challenge_idwall.util.AgencyType;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

@Component
@Slf4j
@RequiredArgsConstructor
@AgencyType("fbi")
public class WebScrapingServiceFBI extends AbstractWebScrapingService {

    private final HttpClientService service;

    @Override
    public Object webScrapingMethod() {
        log.info("[FBI] - Initial process web-scraping.");
        try {
            while (true){
                log.info("[1] - PageSize: {}.", INITIAL_VALUE);
                ObjectResponseDTO response = service.requestToFBI(HOST_FBI, PATH_FBI, buildRequestParams(INITIAL_VALUE));
                log.info("[2] - Validating to response.");
                if (response.getItems().isEmpty())
                    break;

                log.info("[3] - Saving to database.");
                savingToResponse(response);
                // método para salvar no banco

                log.info("[4] - Increment pageSize.");
                INITIAL_VALUE ++;
            }

            return INITIAL_VALUE;
        } catch (RuntimeException e) {
            throw new ResourceNotFoundException("[ERRO] An error occurred while converting the response. Error: " + e.getMessage());
        }
    }

    private void savingToResponse(final ObjectResponseDTO response) {
        response.getItems().forEach(item -> {
            PersonModel personModel = savingToDatabase(mappingToPerson(item));
        });
    }

    private MultiValueMap<String, String> buildRequestParams(final Integer pageSize){
        MultiValueMap<String, String> requestParams = new LinkedMultiValueMap<>();
        requestParams.add("pageSize", "20");
        requestParams.add("page", pageSize.toString());
        return requestParams;
    }
}
