package com.dev.torhugo.challenge_idwall.client;

import com.dev.torhugo.challenge_idwall.lib.data.dto.fbi.ObjectFbiResponseDTO;
import com.dev.torhugo.challenge_idwall.lib.data.dto.interpol.ObjectInterpolResponseDTO;
import com.dev.torhugo.challenge_idwall.lib.data.dto.interpol.image.ObjectResponseImageDTO;
import com.dev.torhugo.challenge_idwall.lib.data.dto.interpol.notice.ObjectInterpolResponseNoticeDTO;
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
    ObjectFbiResponseDTO initialRequestFbi(final String host,
                                           final String path,
                                           final MultiValueMap<String, String> queryParam);

    /**
     * Request to Interpol.
     *
     * @param host       the host
     * @param path       the path
     * @param queryParam key / value
     * @return the object
     */
    ObjectInterpolResponseDTO initialRequestInterpol(final String host,
                                                     final String path,
                                                     final MultiValueMap<String, String> queryParam);

    /**
     * Individual news retrieval.
     *
     * @param hostInterpol the host interpol
     * @param pathInterpol the path interpol
     * @param entityId     the entity id
     * @return the object interpol response notice dto
     */
    ObjectInterpolResponseNoticeDTO retrievalInterpolNotice(final String hostInterpol,
                                                            final String pathInterpol,
                                                            final String entityId);

    /**
     * Retrieval interpol image of suspect.
     *
     * @param hostInterpol      the host interpol
     * @param pathInterpol      the path interpol
     * @param entityId          the entity id
     * @param pathInterpolImage the path interpol image
     * @return the object response image dto
     */
    ObjectResponseImageDTO retrievalInterpolImageSuspect(final String hostInterpol,
                                                         final String pathInterpol,
                                                         final String entityId,
                                                         final String pathInterpolImage);
}
