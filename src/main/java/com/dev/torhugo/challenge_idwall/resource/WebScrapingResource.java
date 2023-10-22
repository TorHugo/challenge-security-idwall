package com.dev.torhugo.challenge_idwall.resource;

import com.dev.torhugo.challenge_idwall.lib.data.dto.webscraping.ResponseFinal;
import com.dev.torhugo.challenge_idwall.service.WebScrapingService;
import com.dev.torhugo.challenge_idwall.service.factory.WebScrapingFactory;
import com.dev.torhugo.challenge_idwall.util.resource.HubResource;
import com.dev.torhugo.challenge_idwall.util.resource.HubResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/web-scraping")
@RequiredArgsConstructor
public class WebScrapingResource implements HubResource {
    private final WebScrapingFactory webScrapingFactory;

    @PostMapping("/{agency}")
    public ResponseEntity<HubResponse<ResponseFinal>> webScrapingStarter(final @PathVariable String agency){
        WebScrapingService service = webScrapingFactory.getProcessor(agency);
        return returnSuccess(service.webScrapingMethod());
    }
}
