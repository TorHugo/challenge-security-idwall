package com.dev.torhugo.challenge_idwall.repositories.impl;

import com.dev.torhugo.challenge_idwall.lib.data.domain.PersonModel;
import com.dev.torhugo.challenge_idwall.repositories.PersonRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Repository;

@Repository
@Slf4j
@PropertySource("classpath:query/person_tb.properties")
public class PersonRepositoryImpl implements PersonRepository {
    @Override
    public void saving(PersonModel personModel) {

    }

    @Override
    public PersonModel retrieveByExternalReference(String externalId) {
        return null;
    }
}
