package com.dev.torhugo.challenge_idwall.client.impl;

import com.dev.torhugo.challenge_idwall.client.HttpClientService;
import com.dev.torhugo.challenge_idwall.lib.data.dto.fbi.ObjectResponseDTO;
import com.dev.torhugo.challenge_idwall.lib.exception.impl.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import static com.dev.torhugo.challenge_idwall.util.StringUtil.generateBaseUri;


@Component
@RequiredArgsConstructor
@Slf4j
public class HttpClientServiceImpl implements HttpClientService {
    private final RestTemplate restTemplate = new RestTemplate();

    private static final String USER_AGENT = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.110 Safari/537.36 Edge/16.16299";

    @Override
    public ObjectResponseDTO requestToFBI(final String host,
                                          final String path,
                                          final MultiValueMap<String, String> queryParam) {

        final String uri = generateBaseUri(host, path);
        final UriComponentsBuilder uriComponentsBuilder = generateComponentBuilder(uri, queryParam);

        try {
            log.info("[GET] - {}.", uriComponentsBuilder.toUriString());
            return restTemplate.exchange(
                    uriComponentsBuilder.toUriString(),
                    HttpMethod.GET,
                    buildToHeaders(),
                    ObjectResponseDTO.class
            ).getBody();
        } catch (final HttpClientErrorException.Unauthorized |
                       HttpClientErrorException.BadRequest |
                       HttpClientErrorException.Forbidden |
                       HttpClientErrorException.NotFound exception) {
            exception.printStackTrace();
            throw new ResourceNotFoundException("Não foi possível realizar a requisição. Error: " + exception.getMessage());
        }
    }

    private HttpEntity<?> buildToHeaders() {
        final HttpHeaders headers = new HttpHeaders();
        headers.set("User-Agent", USER_AGENT);
        return new HttpEntity<>(headers);
    }

    private UriComponentsBuilder generateComponentBuilder(final String uri, final MultiValueMap<String, String> queryParam) {
        return UriComponentsBuilder.fromHttpUrl(uri)
                .queryParams(queryParam);
    }
}
