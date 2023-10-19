package com.dev.torhugo.challenge_idwall.service.impl;

import com.dev.torhugo.challenge_idwall.lib.data.domain.*;
import com.dev.torhugo.challenge_idwall.lib.data.dto.fbi.ObjectItemResponseDTO;
import com.dev.torhugo.challenge_idwall.mapper.*;
import com.dev.torhugo.challenge_idwall.repositories.*;
import com.dev.torhugo.challenge_idwall.service.WebScrapingService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
@AllArgsConstructor
public abstract class AbstractWebScrapingService implements WebScrapingService {
    static Integer initialValue = 1;

    private final PersonRepository personRepository;
    private final AliasRepository aliasRepository;
    private final CharacteristicRepository characteristicRepository;
    private final CrimeRepository crimeRepository;
    private final FileRepository fileRepository;
    private final ImageRepository imageRepository;
    private final MarksRepository marksRepository;
    private final PersonMapper personMapper;
    private final AliasMapper aliasMapper;
    private final CharacteristicMapper characteristicMapper;
    private final CrimeMapper crimeMapper;
    private final FileMapper fileMapper;
    private final ImageMapper imageMapper;
    private final MarksMapper marksMapper;

    @Override
    public <T> PersonModel mappingToPerson(final T response) {
        if (response instanceof ObjectItemResponseDTO item){
            return personMapper.mapperToModel(item);
        }
        return null;
    }

    @Override
    public PersonModel savingToDatabase(final PersonModel personModel) {
        personRepository.saving(personModel);
        return retrieveByExternalReference(personModel.getExternalId());
    }

    @Override
    public PersonModel retrieveByExternalReference(final String externalReference) {
        return personRepository.retrieveByExternalReference(externalReference);
    }

    @Override
    public <T> void savingToDatabase(final PersonModel personModel,
                                     final T item) {
        CharacteristicModel characteristicModel;
        List<AliasModel> lsAliases;
        List<CrimeModel> lsCrimes;
        List<FileModel> lsFiles;
        List<ImageModel> lsImages;
        List<MarksModel> lsMarks;

        if (item instanceof ObjectItemResponseDTO response){
            characteristicModel = characteristicMapper.mappingToRespose(personModel, response);
            lsAliases = aliasMapper.mappingToResponse(personModel, response);
            lsCrimes = crimeMapper.mappingToResponse(personModel, response);
            lsFiles = fileMapper.mappingToResponse(personModel, response);
            lsImages = imageMapper.mappingToResponse(personModel, response);
            lsMarks = marksMapper.mappingToResponse(personModel, response);
        } else {
            return;
        }

        savingToCharacteristic(characteristicModel);
        savingToAliases(lsAliases);
        savingToCrimes(lsCrimes);
        savingToFiles(lsFiles);
        savingToImages(lsImages);
        savingToMarks(lsMarks);
    }

    private void savingToCharacteristic(final CharacteristicModel characteristicModel) {
        characteristicRepository.save(characteristicModel);
    }

    private void savingToAliases(final List<AliasModel> lsAliases) {
        if (Objects.isNull(lsAliases))
            return;
        lsAliases.forEach(aliasRepository::save);
    }

    private void savingToCrimes(final List<CrimeModel> lsCrimes) {
        if (Objects.isNull(lsCrimes))
            return;
        lsCrimes.forEach(crimeRepository::save);
    }

    private void savingToFiles(final List<FileModel> lsFiles) {
        if (Objects.isNull(lsFiles))
            return;
        lsFiles.forEach(fileRepository::save);
    }

    private void savingToImages(final List<ImageModel> lsImages) {
        if (Objects.isNull(lsImages))
            return;
        lsImages.forEach(imageRepository::save);
    }

    private void savingToMarks(final List<MarksModel> lsMarks) {
        if (Objects.isNull(lsMarks))
            return;
        lsMarks.forEach(marksRepository::save);
    }
}
