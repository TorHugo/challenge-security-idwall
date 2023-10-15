package com.dev.torhugo.challenge_idwall.client;

import com.dev.torhugo.challenge_idwall.lib.data.dto.fbi.ObjectResponseDTO;
import org.springframework.util.MultiValueMap;

public interface HttpClientService {

    /**
     * Request to FBI.
     *
     * @param host       the host
     * @param path       the path
     * @param queryParam key / value
     * @return the object
     */
    ObjectResponseDTO requestToFBI(final String host,
                                   final String path,
                                   final MultiValueMap<String, String> queryParam);
}
