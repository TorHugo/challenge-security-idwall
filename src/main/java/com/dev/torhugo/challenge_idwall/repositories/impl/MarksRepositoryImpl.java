package com.dev.torhugo.challenge_idwall.repositories.impl;

import com.dev.torhugo.challenge_idwall.lib.data.database.DatabaseService;
import com.dev.torhugo.challenge_idwall.lib.data.domain.MarksModel;
import com.dev.torhugo.challenge_idwall.mapper.MarksMapper;
import com.dev.torhugo.challenge_idwall.repositories.ImageRepository;
import com.dev.torhugo.challenge_idwall.repositories.MarksRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Repository;

@Repository
@Slf4j
@RequiredArgsConstructor
@PropertySource("classpath:query/marks_tb.properties")
public class MarksRepositoryImpl implements MarksRepository {

    private final DatabaseService service;

    @Value("${SPI.MARKS_TB}")
    private String queryInsertMarks;
    @Override
    public void save(final MarksModel marksModel) {
        service.persist(queryInsertMarks, marksModel);
    }
}
