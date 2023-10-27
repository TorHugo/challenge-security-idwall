package com.dev.torhugo.challenge_idwall.repository.impl;

import com.dev.torhugo.challenge_idwall.lib.data.database.DatabaseService;
import com.dev.torhugo.challenge_idwall.lib.data.domain.service.PersonModel;
import com.dev.torhugo.challenge_idwall.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Slf4j
@RequiredArgsConstructor
@PropertySource("classpath:query/person_tb.properties")
public class PersonRepositoryImpl implements PersonRepository {

    private final DatabaseService databaseService;

    @Value("${SPI.PERSON_TB}")
    private String queryPersistPerson;

    @Value("${SPS.PERSON_TB.WHERE.EXTERNAL_ID}")
    private String queryRetrievePersonByExternalId;


    @Value("${SPS.PERSON_TB.ALL_SUSPECT_AML}")
    private String queryRetrieveAllSuspectAML;

    @Value("${SPS.PERSON_TB.WHERE.PERSON_ID}")
    private String queryRetrieveByPersonId;

    @Value("${SPS.PERSON_TB.WHERE.NAME}")
    private String queryRetrieveByPersonName;

    @Override
    public void saving(final PersonModel personModel) {
        log.info("[-] saving()");
        databaseService.persist(queryPersistPerson, personModel);
    }

    @Override
    public PersonModel retrieveByExternalReference(final String externalId) {
        log.info("[-] retrieveByExternalReference()");
        return databaseService.retrieve(queryRetrievePersonByExternalId,
                        buildParam(externalId),
                        BeanPropertyRowMapper.newInstance(PersonModel.class))
                .orElse(null);
    }

    @Override
    public List<PersonModel> findAllBySuspectAml() {
        return databaseService.retrieveList(queryRetrieveAllSuspectAML,
                BeanPropertyRowMapper.newInstance(PersonModel.class));
    }

    @Override
    public PersonModel retrieveBySuspectId(final Long suspectId) {
        return databaseService.retrieve(queryRetrieveByPersonId,
                        buildParamSuspectId(suspectId),
                        BeanPropertyRowMapper.newInstance(PersonModel.class))
                .orElse(null);
    }

    @Override
    public List<PersonModel> retrieveBySuspectName(final String name) {
        return databaseService.retrieveList(queryRetrieveByPersonName,
                        buildParamSuspectName(name),
                        BeanPropertyRowMapper.newInstance(PersonModel.class));
    }

    private MapSqlParameterSource buildParamSuspectName(final String name) {
        return new MapSqlParameterSource("name", "%" + name + "%");
    }

    private MapSqlParameterSource buildParam(final String externalId) {
        return new MapSqlParameterSource("externalId", externalId);
    }

    private MapSqlParameterSource buildParamSuspectId(final Long suspectId) {
        return new MapSqlParameterSource("personId", suspectId);
    }
}
