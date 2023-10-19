package com.dev.torhugo.challenge_idwall.resource;

import com.dev.torhugo.challenge_idwall.client.HttpClientService;
import com.dev.torhugo.challenge_idwall.util.resource.HubResource;
import com.dev.torhugo.challenge_idwall.util.resource.HubResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/web-scraping/test")
@RequiredArgsConstructor
public class ResourceTest implements HubResource {

    private final HttpClientService service;

    @GetMapping()
    public ResponseEntity<HubResponse<Object>> testing(){
        MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        queryParams.add("pageSize", "20");
        queryParams.add("page", "1");
        Object o = service.initialRequestFbi("https://api.fbi.gov", "/@wanted", queryParams);

        return returnSuccess(o.toString());
    }
}
