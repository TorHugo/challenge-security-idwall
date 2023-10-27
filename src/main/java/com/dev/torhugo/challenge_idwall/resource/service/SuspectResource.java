package com.dev.torhugo.challenge_idwall.resource.service;

import com.dev.torhugo.challenge_idwall.lib.data.dto.verify.ResponseVerifyAmlDTO;
import com.dev.torhugo.challenge_idwall.lib.data.dto.verify.ResponseVerifySuspectDTO;
import com.dev.torhugo.challenge_idwall.service.VerifySuspectService;
import com.dev.torhugo.challenge_idwall.util.resource.HubResource;
import com.dev.torhugo.challenge_idwall.util.resource.HubResponse;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.connector.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
            @PathVariable("suspect-id") final Long suspectId){
        return returnSuccess(service.bySuspectId(suspectId));
    }

    @GetMapping()
    public ResponseEntity<HubResponse<List<ResponseVerifySuspectDTO>>> bySuspectName(
            @RequestParam(name = "name") final String name
    ){
        return returnSuccess(service.bySuspectName(name));
    }
}
