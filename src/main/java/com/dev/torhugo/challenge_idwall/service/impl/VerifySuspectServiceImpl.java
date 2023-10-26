package com.dev.torhugo.challenge_idwall.service.impl;

import com.dev.torhugo.challenge_idwall.lib.data.domain.service.PersonModel;
import com.dev.torhugo.challenge_idwall.lib.data.domain.user.UserModel;
import com.dev.torhugo.challenge_idwall.lib.data.dto.verify.ResponseVerifyAmlDTO;
import com.dev.torhugo.challenge_idwall.lib.data.dto.verify.ResponseVerifySuspectDTO;
import com.dev.torhugo.challenge_idwall.mapper.PersonMapper;
import com.dev.torhugo.challenge_idwall.repository.PersonRepository;
import com.dev.torhugo.challenge_idwall.service.VerifySuspectService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class VerifySuspectServiceImpl implements VerifySuspectService {

    private final PersonRepository personRepository;
    private final PersonMapper personMapper;

    @Override
    public ResponseVerifyAmlDTO allSuspectAml() {
        log.info("[1] - Find all suspect by involvement Money Laundering.");
        final List<PersonModel> lsSuspect = retrieveAllAml();
        log.info("[2] - Mapping to response.");
        return mappingToResponseAllAml(lsSuspect);
    }

    @Override
    public ResponseVerifySuspectDTO bySuspectId(final String suspectId) {
        log.info("[1] - Find suspect by Id: [{}].", suspectId);
        final PersonModel suspect = retrieveById(suspectId);

        return null;
    }

    private PersonModel retrieveById(final String suspectId) {
        return personRepository.retrieveBySuspectId(suspectId);
    }

    private ResponseVerifyAmlDTO mappingToResponseAllAml(final List<PersonModel> lsSuspect) {
        return personMapper.mapperToResponseAllAml(lsSuspect);
    }

    private List<PersonModel> retrieveAllAml() {
        return personRepository.findAllBySuspectAml();
    }
}
