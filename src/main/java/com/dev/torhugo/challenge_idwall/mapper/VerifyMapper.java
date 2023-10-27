package com.dev.torhugo.challenge_idwall.mapper;

import com.dev.torhugo.challenge_idwall.lib.data.domain.service.*;
import com.dev.torhugo.challenge_idwall.lib.data.dto.verify.ResponseVerifySuspectDTO;

import java.util.List;

public interface VerifyMapper {
    /**
     * Mapper to response response verify suspect dto.
     *
     * @param suspect        the suspect
     * @param characteristic the characteristic
     * @param crimes         the crimes
     * @param images         the images
     * @param marks          the marks
     * @param files          the files
     * @param aliases        the aliases
     * @return the response verify suspect dto
     */
    ResponseVerifySuspectDTO mapperToResponse(final PersonModel suspect,
                                              final CharacteristicModel characteristic,
                                              final List<CrimeModel> crimes,
                                              final List<ImageModel> images,
                                              final List<MarksModel> marks,
                                              final List<FileModel> files,
                                              final List<AliasModel> aliases);
}
