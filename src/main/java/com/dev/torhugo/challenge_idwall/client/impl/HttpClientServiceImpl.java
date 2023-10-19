package com.dev.torhugo.challenge_idwall.client.impl;

import com.dev.torhugo.challenge_idwall.client.HttpClientService;
import com.dev.torhugo.challenge_idwall.lib.data.dto.fbi.ObjectFbiResponseDTO;
import com.dev.torhugo.challenge_idwall.lib.data.dto.interpol.ObjectInterpolResponseDTO;
import com.dev.torhugo.challenge_idwall.lib.data.dto.interpol.image.ObjectResponseImageDTO;
import com.dev.torhugo.challenge_idwall.lib.data.dto.interpol.notice.ObjectInterpolResponseNoticeDTO;
import com.dev.torhugo.challenge_idwall.lib.exception.impl.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Objects;

import static com.dev.torhugo.challenge_idwall.util.ConstantsUtil.CARACTER_PATH;
import static com.dev.torhugo.challenge_idwall.util.StringUtil.generateBaseUri;
import static com.dev.torhugo.challenge_idwall.util.ConstantsUtil.USER_AGENT;


@Component
@RequiredArgsConstructor
@Slf4j
public class HttpClientServiceImpl implements HttpClientService {
    private final RestTemplate restTemplate = new RestTemplate();

    @Override
    public ObjectFbiResponseDTO initialRequestFbi(final String host,
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
                    ObjectFbiResponseDTO.class
            ).getBody();
        } catch (final HttpClientErrorException.Unauthorized |
                       HttpClientErrorException.BadRequest |
                       HttpClientErrorException.Forbidden |
                       HttpClientErrorException.NotFound exception) {
            exception.printStackTrace();
            throw new ResourceNotFoundException("Não foi possível realizar a requisição. Error: " + exception.getMessage());
        }
    }

    @Override
    public ObjectInterpolResponseDTO initialRequestInterpol(final String host,
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
                    ObjectInterpolResponseDTO.class
            ).getBody();
        } catch (final HttpClientErrorException.Unauthorized |
                       HttpClientErrorException.BadRequest |
                       HttpClientErrorException.Forbidden |
                       HttpClientErrorException.NotFound exception) {
            exception.printStackTrace();
            throw new ResourceNotFoundException("Não foi possível realizar a requisição. Error: " + exception.getMessage());
        }
    }

    @Override
    public ObjectInterpolResponseNoticeDTO retrievalInterpolNotice(final String hostInterpol,
                                                                   final String pathInterpol,
                                                                   final String entityId) {

        final String uri = generateBaseUri(hostInterpol, pathInterpol);
        final UriComponentsBuilder uriComponentsBuilder = generateComponentBuilder(uri, entityId, null);

        try {
            log.info("[GET] - {}.", uriComponentsBuilder.toUriString());
            return restTemplate.exchange(
                    uriComponentsBuilder.toUriString(),
                    HttpMethod.GET,
                    buildToHeaders(),
                    ObjectInterpolResponseNoticeDTO.class
            ).getBody();
        } catch (final HttpClientErrorException.Unauthorized |
                       HttpClientErrorException.BadRequest |
                       HttpClientErrorException.Forbidden |
                       HttpClientErrorException.NotFound exception) {
            exception.printStackTrace();
            throw new ResourceNotFoundException("Não foi possível realizar a requisição. Error: " + exception.getMessage());
        }
    }

    @Override
    public ObjectResponseImageDTO retrievalInterpolImageSuspect(final String hostInterpol,
                                                                final String pathInterpol,
                                                                final String entityId,
                                                                final String pathInterpolImage) {
        final String uri = generateBaseUri(hostInterpol, pathInterpol);
        final UriComponentsBuilder uriComponentsBuilder = generateComponentBuilder(uri, entityId, pathInterpolImage);

        try {
            log.info("[GET] - {}.", uriComponentsBuilder.toUriString());
            return restTemplate.exchange(
                    uriComponentsBuilder.toUriString(),
                    HttpMethod.GET,
                    buildToHeaders(),
                    ObjectResponseImageDTO.class
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

    private UriComponentsBuilder generateComponentBuilder(final String uri, final String pathOne, final String pathTwo) {
        if (Objects.isNull(pathTwo))
            return UriComponentsBuilder.fromHttpUrl(uri)
                    .path(CARACTER_PATH)
                    .path(pathOne);

        return UriComponentsBuilder.fromHttpUrl(uri)
                .path(CARACTER_PATH)
                .path(pathOne)
                .path(CARACTER_PATH)
                .path(pathTwo);
    }
}
