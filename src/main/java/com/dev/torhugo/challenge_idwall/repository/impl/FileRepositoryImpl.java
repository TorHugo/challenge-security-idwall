package com.dev.torhugo.challenge_idwall.repository.impl;

import com.dev.torhugo.challenge_idwall.lib.data.database.DatabaseService;
import com.dev.torhugo.challenge_idwall.lib.data.domain.service.FileModel;
import com.dev.torhugo.challenge_idwall.lib.data.domain.service.ImageModel;
import com.dev.torhugo.challenge_idwall.repository.FileRepository;
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
@PropertySource("classpath:query/file_tb.properties")
public class FileRepositoryImpl implements FileRepository {

    private final DatabaseService service;

    @Value("${SPI.FILE_TB}")
    private String queryInsertFile;

    @Value("${SPS.FILE_TB.WHERE.PERSON_ID}")
    private String queryRetrieveFileByPersonId;

    @Override
    public void save(final FileModel fileModel) {
        service.persist(queryInsertFile, fileModel);
    }

    @Override
    public List<FileModel> findBySuspectId(final Long suspectId) {
        return service.retrieveList(queryRetrieveFileByPersonId,
                buildParam(suspectId),
                BeanPropertyRowMapper.newInstance(FileModel.class));
    }

    private MapSqlParameterSource buildParam(final Long suspectId) {
        return new MapSqlParameterSource("suspectId", suspectId);
    }
}
