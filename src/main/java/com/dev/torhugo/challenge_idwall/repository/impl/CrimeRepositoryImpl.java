package com.dev.torhugo.challenge_idwall.repository.impl;

import com.dev.torhugo.challenge_idwall.lib.data.database.DatabaseService;
import com.dev.torhugo.challenge_idwall.lib.data.domain.service.CrimeModel;
import com.dev.torhugo.challenge_idwall.repository.CrimeRepository;
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
@PropertySource("classpath:query/crime_tb.properties")
public class CrimeRepositoryImpl implements CrimeRepository {

    private final DatabaseService service;

    @Value("${SPI.CRIME_TB}")
    private String queryInsertCrime;

    @Value("${SPS.CRIME_TB.WHERE.PERSON_ID}")
    private String queryRetrieveCrimeByPersonId;

    @Override
    public void save(final CrimeModel crimeModel) {
        service.persist(queryInsertCrime, crimeModel);
    }

    @Override
    public List<CrimeModel> findBySuspectId(final Long suspectId) {
        return service.retrieveList(queryRetrieveCrimeByPersonId,
                buildParam(suspectId),
                BeanPropertyRowMapper.newInstance(CrimeModel.class));
    }

    private MapSqlParameterSource buildParam(final Long suspectId) {
        return new MapSqlParameterSource("suspectId", suspectId);
    }
}
