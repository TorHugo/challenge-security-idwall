package com.dev.torhugo.challenge_idwall.repository.impl;

import com.dev.torhugo.challenge_idwall.lib.data.database.DatabaseService;
import com.dev.torhugo.challenge_idwall.lib.data.domain.service.ImageModel;
import com.dev.torhugo.challenge_idwall.lib.data.domain.service.MarksModel;
import com.dev.torhugo.challenge_idwall.repository.MarksRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Slf4j
@RequiredArgsConstructor
@PropertySource("classpath:query/marks_tb.properties")
public class MarksRepositoryImpl implements MarksRepository {

    private final DatabaseService service;

    @Value("${SPI.MARKS_TB}")
    private String queryInsertMarks;

    @Value("${SPS.MARKS_TB.WHERE.PERSON_ID}")
    private String queryRetrieveMarksByPersonId;

    @Override
    public void save(final MarksModel marksModel) {
        service.persist(queryInsertMarks, marksModel);
    }

    @Override
    public List<MarksModel> findBySuspectId(final Long suspectId) {
        return service.retrieveList(queryRetrieveMarksByPersonId,
                buildParam(suspectId),
                BeanPropertyRowMapper.newInstance(MarksModel.class));
    }

    private MapSqlParameterSource buildParam(final Long suspectId) {
        return new MapSqlParameterSource("suspectId", suspectId);
    }
}
