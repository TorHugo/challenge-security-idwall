package com.dev.torhugo.challenge_idwall.service.impl;

import com.dev.torhugo.challenge_idwall.client.HttpClientService;
import com.dev.torhugo.challenge_idwall.lib.data.dto.interpol.ObjectInterpolResponseDTO;
import com.dev.torhugo.challenge_idwall.lib.data.dto.interpol.image.ObjectResponseImageDTO;
import com.dev.torhugo.challenge_idwall.lib.data.dto.interpol.initial.LinkResponseDTO;
import com.dev.torhugo.challenge_idwall.lib.data.dto.interpol.notice.ObjectInterpolResponseNoticeDTO;
import com.dev.torhugo.challenge_idwall.lib.exception.impl.ResourceNotFoundException;
import com.dev.torhugo.challenge_idwall.mapper.*;
import com.dev.torhugo.challenge_idwall.repositories.*;
import com.dev.torhugo.challenge_idwall.util.AgencyType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.util.Objects;

import static com.dev.torhugo.challenge_idwall.util.ConstantsUtil.*;

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
        try {
            while (true){
                log.info("[1] - PageSize: {}.", initialValue);
                final ObjectInterpolResponseDTO response = initialRequestInterpol(initialValue);

                log.info("[2] - Process individual notice.");
                processNoticies(response);

                log.info("[3] - Validating to response.");
                if (Objects.isNull(response.getLinks().getNext())){
                    log.info("[4] - No response.");
                    break;
                }
                log.info("[4] - Increment pageSize.");
                initialValue += 1;
            }

            return initialValue;
        } catch (RuntimeException e) {
            e.printStackTrace();
            throw new ResourceNotFoundException("[ERROR] An error occurred while web-scraping. Error: " + e.getMessage());
        }
    }

    private void processNoticies(final ObjectInterpolResponseDTO response) {
        response.getEmbedded().getNotices().forEach(notice -> {
            final ObjectInterpolResponseNoticeDTO noticeResponse = retrievalNotice(convertEntityId(notice.getEntityId()));
            final ObjectResponseImageDTO images = retrievalImageSuspect(convertEntityId(notice.getEntityId()), notice.getLinks());
        });
    }

    private String convertEntityId(final String entityId) {
        return entityId.replace("/", "-");
    }

    private ObjectInterpolResponseNoticeDTO retrievalNotice(final String entityId) {
        return service.retrievalInterpolNotice(HOST_INTERPOL, PATH_INTERPOL, entityId);
    }

    private ObjectResponseImageDTO retrievalImageSuspect(final String entityId, final LinkResponseDTO notice) {
        if (Objects.isNull(notice.getImages()))
            return null;

        return service.retrievalInterpolImageSuspect(HOST_INTERPOL, PATH_INTERPOL, entityId, PATH_INTERPOL_IMAGE);
    }

    private ObjectInterpolResponseDTO initialRequestInterpol(final Integer initialValue) {
        return service.initialRequestInterpol(HOST_INTERPOL, PATH_INTERPOL, buildRequestParams(initialValue));
    }

    private MultiValueMap<String, String> buildRequestParams(final Integer pageSize){
        MultiValueMap<String, String> requestParams = new LinkedMultiValueMap<>();
        requestParams.add("resultPerPage", "50");
        requestParams.add("page", pageSize.toString());
        return requestParams;
    }
}
