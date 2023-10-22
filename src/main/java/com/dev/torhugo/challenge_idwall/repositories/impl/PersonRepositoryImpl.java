package com.dev.torhugo.challenge_idwall.repositories.impl;

import com.dev.torhugo.challenge_idwall.lib.data.database.DatabaseService;
import com.dev.torhugo.challenge_idwall.lib.data.domain.service.PersonModel;
import com.dev.torhugo.challenge_idwall.repositories.PersonRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
@Slf4j
@RequiredArgsConstructor
@PropertySource("classpath:query/person_tb.properties")
public class PersonRepositoryImpl implements PersonRepository {

    private final DatabaseService databaseService;

    @Value("${SPI.PERSON}")
    private String queryPersistPerson;

    @Value("${SPS.PERSON.WHERE.EXTERNAL_ID}")
    private String queryRetrievePersonByExternalId;

    @Override
    public void saving(final PersonModel personModel) {
        log.info("[-] saving()");
        databaseService.persist(queryPersistPerson, personModel);
    }

    @Override
    public PersonModel retrieveByExternalReference(final String externalId) {
        log.info("[-] retrieveByExternalReference()");
        return databaseService.retrieve(queryRetrievePersonByExternalId,
                buildParam(externalId), BeanPropertyRowMapper.newInstance(PersonModel.class))
                .orElse(null);
    }

    private MapSqlParameterSource buildParam(final String externalId) {
        return new MapSqlParameterSource("externalId", externalId);
    }
}
