package com.dev.torhugo.challenge_idwall.mapper;

import com.dev.torhugo.challenge_idwall.lib.data.domain.service.PersonModel;
import com.dev.torhugo.challenge_idwall.lib.data.dto.fbi.ObjectItemResponseDTO;
import com.dev.torhugo.challenge_idwall.lib.data.dto.interpol.initial.NoticeResponseDTO;
import com.dev.torhugo.challenge_idwall.lib.data.dto.verify.ResponseVerifyAmlDTO;

import java.util.List;

public interface PersonMapper {
    /**
     * Mapper to model person model.
     *
     * @param item the item
     * @return the person model
     */
    PersonModel mapperToModel(final ObjectItemResponseDTO item);
    /**
     * Mapper to model person model.
     *
     * @param notice the item
     * @return the person model
     */
    PersonModel mapperToModel(final NoticeResponseDTO notice);

    /**
     * Mapper to response all aml response verify aml dto.
     *
     * @param lsSuspect the ls suspect
     * @return the response verify aml dto
     */
    ResponseVerifyAmlDTO mapperToResponseAllAml(List<PersonModel> lsSuspect);
}
