package com.dev.torhugo.challenge_idwall.resource.service;

import com.dev.torhugo.challenge_idwall.lib.data.dto.annotation.RequestAnnotationDTO;
import com.dev.torhugo.challenge_idwall.lib.data.dto.annotation.ResponseAnnotationSuccessDTO;
import com.dev.torhugo.challenge_idwall.lib.data.dto.annotation.ResponseBaseAnnotationDTO;
import com.dev.torhugo.challenge_idwall.service.AnnotationService;
import com.dev.torhugo.challenge_idwall.util.resource.HubResource;
import com.dev.torhugo.challenge_idwall.util.resource.HubResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/annotation")
@RequiredArgsConstructor
public class AnnotationResource implements HubResource {

    private final AnnotationService annotationService;

    @PostMapping("/save")
    public ResponseEntity<HubResponse<ResponseAnnotationSuccessDTO>> create(
            @RequestBody final RequestAnnotationDTO dto
    ){
        return returnSuccess(annotationService.createAnnotation(dto));
    }

    @GetMapping("/{user_id}")
    public ResponseEntity<HubResponse<ResponseBaseAnnotationDTO>> findAllByUserId(
            @PathVariable(value = "user_id") final Long userId){
        return returnSuccess(annotationService.findAllByUserId(userId));
    }
}
