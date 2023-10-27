package com.dev.torhugo.challenge_idwall.repository.impl;

import com.dev.torhugo.challenge_idwall.lib.data.database.DatabaseService;
import com.dev.torhugo.challenge_idwall.lib.data.domain.service.CharacteristicModel;
import com.dev.torhugo.challenge_idwall.repository.CharacteristicRepository;
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
@PropertySource("classpath:query/characterisctic_tb.properties")
public class CharacteriscticRepositoryImpl implements CharacteristicRepository {

    private final DatabaseService service;

    @Value("${SPI.CHARACTERISTIC_TB}")
    private String queryInsertCharacteristic;

    @Value("${SPS.CHARACTERISTIC_TB.WHERE.PERSON_ID}")
    private String queryRetrieveCharacteristicByPersonId;

    @Override
    public void save(final CharacteristicModel characteristicModel) {
        service.persist(queryInsertCharacteristic, characteristicModel);
    }

    @Override
    public CharacteristicModel findBySuspectId(final Long suspectId) {
        return service.retrieve(queryRetrieveCharacteristicByPersonId,
                    buildParam(suspectId),
                    BeanPropertyRowMapper.newInstance(CharacteristicModel.class))
                .orElse(null);
    }

    private MapSqlParameterSource buildParam(final Long suspectId) {
        return new MapSqlParameterSource("suspectId", suspectId);
    }
}
