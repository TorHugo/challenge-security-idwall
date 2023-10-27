package com.dev.torhugo.challenge_idwall.service.impl;

import com.dev.torhugo.challenge_idwall.lib.data.domain.user.AnnotationModel;
import com.dev.torhugo.challenge_idwall.lib.data.domain.user.UserModel;
import com.dev.torhugo.challenge_idwall.lib.data.dto.annotation.RequestAnnotationDTO;
import com.dev.torhugo.challenge_idwall.lib.data.dto.annotation.ResponseAnnotationSuccessDTO;
import com.dev.torhugo.challenge_idwall.lib.data.dto.annotation.ResponseBaseAnnotationDTO;
import com.dev.torhugo.challenge_idwall.lib.exception.impl.DataBaseException;
import com.dev.torhugo.challenge_idwall.mapper.AnnotationMapper;
import com.dev.torhugo.challenge_idwall.repository.AnnotationRepository;
import com.dev.torhugo.challenge_idwall.repository.UserRepository;
import com.dev.torhugo.challenge_idwall.service.AnnotationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

import static com.dev.torhugo.challenge_idwall.util.ConstantsUtil.PATH_REGISTER_USER;

@Service
@RequiredArgsConstructor
@Slf4j
public class AnnotationServiceImpl implements AnnotationService {

    private final AnnotationRepository annotationRepository;
    private final UserRepository userRepository;
    private final AnnotationMapper annotationMapper;

    @Override
    public ResponseAnnotationSuccessDTO createAnnotation(final RequestAnnotationDTO request) {
        log.info("[1] - Validating exists by userId. UserId: [{}].", request.userId());
        final UserModel user = retrieveUser(request.userId());
        if (Objects.isNull(user))
            throw new DataBaseException("User not found!", request.userId(), PATH_REGISTER_USER, "[POST]");
        log.info("[2] - Mapping to AnnotationModel.");
        final AnnotationModel annotationModel = mappingToModel(request);
        log.info("[3] - Saving in the database.");
        final AnnotationModel annotationSaved = saved(annotationModel);
        log.info("[4] - Mapping to response.");
        return mappingToResponse(annotationSaved);
    }

    @Override
    public ResponseBaseAnnotationDTO findAllByUserId(final Long userId) {
        log.info("[1] - Validating exists by userId. UserId: [{}].", userId);
        final UserModel user = retrieveUser(userId);
        if (Objects.isNull(user))
            throw new DataBaseException("User not found!", userId, PATH_REGISTER_USER, "[POST]");
        log.info("[2] - Retrieve All annotations.");
        List<AnnotationModel> annotations = retrieveAll(userId);
        log.info("[3] - Mapping to response.");
        return mappingToResponseAll(annotations, userId);
    }

    private ResponseBaseAnnotationDTO mappingToResponseAll(final List<AnnotationModel> annotations, final Long userId) {
        return annotationMapper.mappingToResponseAll(annotations, userId);
    }

    private List<AnnotationModel> retrieveAll(final Long userId) {
        return annotationRepository.retrieveByUserId(userId);
    }

    private ResponseAnnotationSuccessDTO mappingToResponse(final AnnotationModel annotationSaved) {
        return annotationMapper.mappingToResponse(annotationSaved);
    }

    private AnnotationModel saved(final AnnotationModel annotationModel) {
        annotationRepository.save(annotationModel);
        return annotationRepository.retrieveByUserIdAndCardName(annotationModel);
    }

    private AnnotationModel mappingToModel(final RequestAnnotationDTO request) {
        return annotationMapper.mappingToModel(request);
    }

    private UserModel retrieveUser(final Long userId) {
        return userRepository.findById(userId);
    }
}
