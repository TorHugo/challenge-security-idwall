package com.dev.torhugo.challenge_idwall.repository.impl;

import com.dev.torhugo.challenge_idwall.lib.data.database.DatabaseService;
import com.dev.torhugo.challenge_idwall.lib.data.domain.user.AnnotationModel;
import com.dev.torhugo.challenge_idwall.repository.AnnotationRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
@Slf4j
@RequiredArgsConstructor
@PropertySource("classpath:query/annotation_tb.properties")
public class AnnotationRepositoryImpl implements AnnotationRepository {

    private final DatabaseService service;

    @Value("${SPI.ANNOTATION_TB}")
    private String queryPersistAnnotation;

    @Value("${SPS.ANNOTATION_TB.WHERE.USER_ID.AND.CARD_NAME}")
    private String queryRetrieveByUserIdAndCardName;
    @Value("${SPS.ANNOTATION_TB.WHERE.USER_ID}")
    private String queryRetrieveByUserId;

    @Override
    public void save(final AnnotationModel annotationModel) {
        service.persist(queryPersistAnnotation, annotationModel);
    }

    @Override
    public AnnotationModel retrieveByUserIdAndCardName(final AnnotationModel annotationModel) {
        return service.retrieveList(queryRetrieveByUserIdAndCardName,
                buildParam(annotationModel.getUserId(), annotationModel.getCardName()),
                BeanPropertyRowMapper.newInstance(AnnotationModel.class))
                .stream().findFirst().orElse(null);
    }

    @Override
    public List<AnnotationModel> retrieveByUserId(final Long userId) {
        return service.retrieveList(queryRetrieveByUserId,
                buildParam(userId),
                BeanPropertyRowMapper.newInstance(AnnotationModel.class));
    }

    private MapSqlParameterSource buildParam(final Long userId) {
        return new MapSqlParameterSource("userId", userId);
    }

    private MapSqlParameterSource buildParam(final Long userId, final String cardName) {
        MapSqlParameterSource param = new MapSqlParameterSource();
        param.addValue("userId", userId);
        param.addValue("cardName", cardName);

        return param;
    }
}
