package com.dev.torhugo.challenge_idwall.service.impl;

import com.dev.torhugo.challenge_idwall.lib.data.domain.PersonModel;
import com.dev.torhugo.challenge_idwall.lib.data.dto.fbi.ObjectItemResponseDTO;
import com.dev.torhugo.challenge_idwall.mapper.PersonMapper;
import com.dev.torhugo.challenge_idwall.repositories.PersonRepository;
import com.dev.torhugo.challenge_idwall.service.WebScrapingService;
import lombok.RequiredArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public abstract class AbstractWebScrapingService implements WebScrapingService {
    static Integer initialValue = 1;

    private final PersonRepository personRepository;
    private final PersonMapper personMapper;

    @Override
    public <T> PersonModel mappingToPerson(final T response) {
        if (response instanceof ObjectItemResponseDTO item){
            return personMapper.mapperToModel(item);
        }
        return null;
    }

    @Override
    public PersonModel savingToDatabase(final PersonModel personModel) {
        personRepository.saving(personModel);
        return personRepository.retrieveByExternalReference(personModel.getExternalId());
    }
}
