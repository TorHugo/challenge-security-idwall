package com.dev.torhugo.challenge_idwall.service.impl;

import com.dev.torhugo.challenge_idwall.lib.data.domain.service.*;
import com.dev.torhugo.challenge_idwall.lib.data.domain.user.UserModel;
import com.dev.torhugo.challenge_idwall.lib.data.dto.verify.ResponseVerifyAmlDTO;
import com.dev.torhugo.challenge_idwall.lib.data.dto.verify.ResponseVerifySuspectDTO;
import com.dev.torhugo.challenge_idwall.lib.exception.impl.DataBaseException;
import com.dev.torhugo.challenge_idwall.mapper.PersonMapper;
import com.dev.torhugo.challenge_idwall.mapper.VerifyMapper;
import com.dev.torhugo.challenge_idwall.repository.*;
import com.dev.torhugo.challenge_idwall.service.VerifySuspectService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static com.dev.torhugo.challenge_idwall.util.ConstantsUtil.PATH_REGISTER_USER;

@Service
@RequiredArgsConstructor
@Slf4j
public class VerifySuspectServiceImpl implements VerifySuspectService {

    private final PersonRepository personRepository;
    private final CharacteristicRepository characteristicRepository;
    private final CrimeRepository crimeRepository;
    private final ImageRepository imageRepository;
    private final MarksRepository marksRepository;
    private final FileRepository fileRepository;
    private final AliasRepository aliasRepository;
    private final PersonMapper personMapper;
    private final VerifyMapper verifyMapper;

    @Override
    public ResponseVerifyAmlDTO allSuspectAml() {
        log.info("[1] - Find all suspect by involvement Money Laundering.");
        final List<PersonModel> lsSuspect = retrieveAllAml();
        log.info("[2] - Mapping to response.");
        return mappingToResponseAllAml(lsSuspect);
    }

    @Override
    public ResponseVerifySuspectDTO bySuspectId(final Long suspectId) {
        log.info("[1] - Find suspect by Id: [{}].", suspectId);
        final PersonModel suspect = retrieveById(suspectId);
        log.info("[2] - Validating exists user.");
        if (Objects.isNull(suspect))
            throw new DataBaseException("User not found!", suspectId, PATH_REGISTER_USER, "[POST]");
        return mappingToResponse(suspect);
    }

    @Override
    public List<ResponseVerifySuspectDTO> bySuspectName(final String name) {
        log.info("[1] - Find suspect by name: [{}].", name);
        final List<PersonModel> lsSuspect = retrieveByName(name);
        log.info("[2] - Validating exists user.");
        if (lsSuspect.isEmpty())
            throw new DataBaseException("User not found!", name, PATH_REGISTER_USER, "[POST]");
        return mappingToResponse(lsSuspect);
    }

    private List<ResponseVerifySuspectDTO> mappingToResponse(final List<PersonModel> lsSuspect) {
        return lsSuspect.stream().map(this::mappingToResponse).toList();
    }

    private List<PersonModel> retrieveByName(final String name) {
        return personRepository.retrieveBySuspectName(name);
    }

    private PersonModel retrieveById(final Long suspectId) {
        return personRepository.retrieveBySuspectId(suspectId);
    }

    private ResponseVerifyAmlDTO mappingToResponseAllAml(final List<PersonModel> lsSuspect) {
        return personMapper.mapperToResponseAllAml(lsSuspect);
    }


    private List<AliasModel> retrieveAlias(final Long suspectId) {
        return aliasRepository.findBySuspectId(suspectId);
    }

    private List<FileModel> retrieveFiles(final Long suspectId) {
        return fileRepository.findBySuspectId(suspectId);
    }

    private List<MarksModel> retrieveMarks(final Long suspectId) {
        return marksRepository.findBySuspectId(suspectId);
    }

    private List<ImageModel> retrieveImages(final Long suspectId) {
        return imageRepository.findBySuspectId(suspectId);
    }

    private List<CrimeModel> retrieveCrimes(final Long suspectId) {
        return crimeRepository.findBySuspectId(suspectId);
    }

    private CharacteristicModel retrieveCharacteristic(final Long suspectId) {
        return characteristicRepository.findBySuspectId(suspectId);
    }
    private ResponseVerifySuspectDTO mappingToResponse(final PersonModel suspect) {
        log.info("[-] - Find characteristc.");
        final CharacteristicModel characteristic = retrieveCharacteristic(suspect.getPersonId());
        log.info("[-] - Find crimes.");
        final List<CrimeModel> crimes = retrieveCrimes(suspect.getPersonId());
        log.info("[-] - Find images.");
        final List<ImageModel> images = retrieveImages(suspect.getPersonId());
        log.info("[-] - Find marks.");
        final List<MarksModel> marks = retrieveMarks(suspect.getPersonId());
        log.info("[-] - Find files.");
        final List<FileModel> files = retrieveFiles(suspect.getPersonId());
        log.info("[-] - Find aliases.");
        final List<AliasModel> aliases = retrieveAlias(suspect.getPersonId());
        log.info("[-] - Mapping to response.");
        return verifyMapper.mapperToResponse(suspect, characteristic, crimes, images, marks, files, aliases);
    }

    private List<PersonModel> retrieveAllAml() {
        return personRepository.findAllBySuspectAml();
    }
}
