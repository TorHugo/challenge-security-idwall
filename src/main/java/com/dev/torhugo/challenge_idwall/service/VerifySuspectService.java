package com.dev.torhugo.challenge_idwall.service;

import com.dev.torhugo.challenge_idwall.lib.data.dto.verify.ResponseVerifyAmlDTO;
import com.dev.torhugo.challenge_idwall.lib.data.dto.verify.ResponseVerifySuspectDTO;

import java.util.List;

public interface VerifySuspectService {

    /**
     * All suspects in the database, who may be involved in <br/>
     * <b><i>Anti Money Laundering (AML)</i></b>.
     *
     * @return {@link ResponseVerifyAmlDTO}
     */
    ResponseVerifyAmlDTO allSuspectAml();

    /**
     * By suspect id response verify suspect dto.
     *
     * @param suspectId the suspect id
     * @return the response verify suspect dto
     */
    ResponseVerifySuspectDTO bySuspectId(final Long suspectId);

    /**
     * By suspect name response verify suspect dto.
     *
     * @param name the name
     * @return the response verify suspect dto
     */
    List<ResponseVerifySuspectDTO> bySuspectName(final String name);
}
