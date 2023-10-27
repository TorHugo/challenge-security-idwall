package com.dev.torhugo.challenge_idwall.mapper.impl;

import com.dev.torhugo.challenge_idwall.lib.data.domain.service.*;
import com.dev.torhugo.challenge_idwall.lib.data.dto.verify.BaseSuspectDTO;
import com.dev.torhugo.challenge_idwall.lib.data.dto.verify.ResponseVerifySuspectDTO;
import com.dev.torhugo.challenge_idwall.lib.data.dto.verify.suspect.*;
import com.dev.torhugo.challenge_idwall.mapper.VerifyMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class VerifyMapperImpl implements VerifyMapper {

    @Override
    public ResponseVerifySuspectDTO mapperToResponse(final PersonModel suspect,
                                                     final CharacteristicModel characteristic,
                                                     final List<CrimeModel> crimes,
                                                     final List<ImageModel> images,
                                                     final List<MarksModel> marks,
                                                     final List<FileModel> files,
                                                     final List<AliasModel> aliases) {
        return ResponseVerifySuspectDTO.builder()
                .suspect(mappingSuspect(suspect))
                .characteristc(mappingCharacteristic(characteristic))
                .crimes(mappingCrimes(crimes))
                .images(mappingImages(images))
                .marks(mappingMarks(marks))
                .files(mappingFiles(files))
                .aliases(mappingAliases(aliases))
                .build();
    }

    private List<ResponseSuspectAliasDTO> mappingAliases(final List<AliasModel> aliases) {
        return aliases.stream().map(alias ->
                        ResponseSuspectAliasDTO.builder()
                                .name(alias.getAliasDescription())
                                .build())
                .collect(Collectors.toList());
    }

    private List<ResponseSuspectFileDTO> mappingFiles(final List<FileModel> files) {
        return files.stream().map(file ->
                        ResponseSuspectFileDTO.builder()
                                .languageFile(file.getLanguageFile())
                                .fileUri(file.getExternalUri())
                                .build())
                .collect(Collectors.toList());
    }

    private List<ResponseSuspectMarkDTO> mappingMarks(final List<MarksModel> marks) {
        return marks.stream().map(mark ->
                        ResponseSuspectMarkDTO.builder()
                                .description(mark.getMarksDescription())
                                .build())
                .collect(Collectors.toList());
    }

    private List<ResponseSuspectImageDTO> mappingImages(final List<ImageModel> images) {
        return images.stream().map(image ->
                ResponseSuspectImageDTO.builder()
                        .caption(image.getImageCaption())
                        .imageUri(image.getExternalUri())
                        .build())
                .collect(Collectors.toList());
    }

    private List<ResponseVerifySuspectCrimeDTO> mappingCrimes(final List<CrimeModel> crimes) {
        return crimes.stream().map(crime ->
            ResponseVerifySuspectCrimeDTO.builder()
                    .description(crime.getCrimeDescription())
                    .build()
        ).collect(Collectors.toList());
    }

    private ResponseSuspectCharacteristicDTO mappingCharacteristic(final CharacteristicModel characteristic) {
        return ResponseSuspectCharacteristicDTO.builder()
                .ageRange(characteristic.getAgeRange())
                .birthPlace(characteristic.getBirthPlace())
                .eyeColor(characteristic.getEyeColor())
                .ethnicity(characteristic.getEthnicity())
                .height(characteristic.getHeight())
                .weight(characteristic.getWeight())
                .nationality(characteristic.getNationality())
                .sex(characteristic.getSex())
                .build();
    }

    private BaseSuspectDTO mappingSuspect(final PersonModel suspect) {
        return BaseSuspectDTO.builder()
                .personId(suspect.getPersonId())
                .name(suspect.getTitlePublication())
                .description(suspect.getPersonDescription())
                .criminalClassification(suspect.getCriminalClassification())
                .datePublication(suspect.getDatePublication())
                .build();
    }
}
