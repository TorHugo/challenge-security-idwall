package com.dev.torhugo.challenge_idwall.repository.impl;

import com.dev.torhugo.challenge_idwall.lib.data.database.DatabaseService;
import com.dev.torhugo.challenge_idwall.lib.data.domain.service.CrimeModel;
import com.dev.torhugo.challenge_idwall.lib.data.domain.service.ImageModel;
import com.dev.torhugo.challenge_idwall.repository.ImageRepository;
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
@PropertySource("classpath:query/image_tb.properties")
public class ImageRepositoryImpl implements ImageRepository {

    private final DatabaseService service;

    @Value("${SPI.IMAGE_TB}")
    private String queryInsertImage;

    @Value("${SPS.IMAGE_TB.WHERE.PERSON_ID}")
    private String queryRetrieveImageByPersonId;

    @Override
    public void save(final ImageModel imageModel) {
        service.persist(queryInsertImage, imageModel);
    }

    @Override
    public List<ImageModel> findBySuspectId(final Long suspectId) {
        return service.retrieveList(queryRetrieveImageByPersonId,
                buildParam(suspectId),
                BeanPropertyRowMapper.newInstance(ImageModel.class));
    }

    private MapSqlParameterSource buildParam(final Long suspectId) {
        return new MapSqlParameterSource("suspectId", suspectId);
    }
}
