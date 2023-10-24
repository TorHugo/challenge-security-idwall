package com.dev.torhugo.challenge_idwall.service;

import com.dev.torhugo.challenge_idwall.lib.data.dto.verify.ResponseVerifyAmlDTO;

public interface VerifySuspectService {

    /**
     * All suspects in the database, who may be involved in <br/>
     * <b><i>Anti Money Laundering (AML)</i></b>.
     *
     * @return {@link ResponseVerifyAmlDTO}
     */
    ResponseVerifyAmlDTO allSuspectAml();
}
