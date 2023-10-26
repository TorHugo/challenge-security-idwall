package com.dev.torhugo.challenge_idwall.resource.service;

import com.dev.torhugo.challenge_idwall.lib.data.dto.verify.ResponseVerifyAmlDTO;
import com.dev.torhugo.challenge_idwall.lib.data.dto.verify.ResponseVerifySuspectDTO;
import com.dev.torhugo.challenge_idwall.service.VerifySuspectService;
import com.dev.torhugo.challenge_idwall.util.resource.HubResource;
import com.dev.torhugo.challenge_idwall.util.resource.HubResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/verify-suspect")
@RequiredArgsConstructor
public class SuspectResource implements HubResource {

    private final VerifySuspectService service;

    @GetMapping("/aml")
    public ResponseEntity<HubResponse<ResponseVerifyAmlDTO>> allSuspectAML(){
        return returnSuccess(service.allSuspectAml());
    }

    @GetMapping("/{suspect-id}")
    public ResponseEntity<HubResponse<ResponseVerifySuspectDTO>> bySuspectId(
            @PathVariable("suspect-id") final String suspectId){
        return returnSuccess(service.bySuspectId(suspectId));
    }
}
