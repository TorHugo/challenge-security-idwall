package com.dev.torhugo.challenge_idwall.lib.data.dto.verify;

import com.dev.torhugo.challenge_idwall.lib.data.dto.verify.suspect.*;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;

import java.util.List;

@Builder
public record ResponseVerifySuspectDTO(
        BaseSuspectDTO suspect,
        ResponseSuspectCharacteristicDTO characteristc,
        @JsonInclude(JsonInclude.Include.NON_NULL)
        List<ResponseVerifySuspectCrimeDTO> crimes,
        @JsonInclude(JsonInclude.Include.NON_NULL)
        List<ResponseSuspectImageDTO> images,
        @JsonInclude(JsonInclude.Include.NON_NULL)
        List<ResponseSuspectMarkDTO> marks,
        @JsonInclude(JsonInclude.Include.NON_NULL)
        List<ResponseSuspectFileDTO> files,
        @JsonInclude(JsonInclude.Include.NON_NULL)
        List<ResponseSuspectAliasDTO> aliases
        ) {
}


