package com.dev.torhugo.challenge_idwall.mapper;

import com.dev.torhugo.challenge_idwall.lib.data.domain.PersonModel;
import com.dev.torhugo.challenge_idwall.lib.data.dto.fbi.ObjectItemResponseDTO;
import com.dev.torhugo.challenge_idwall.lib.data.dto.interpol.ObjectInterpolResponseDTO;
import com.dev.torhugo.challenge_idwall.lib.data.dto.interpol.initial.NoticeResponseDTO;
import com.dev.torhugo.challenge_idwall.lib.data.dto.interpol.notice.ObjectInterpolResponseNoticeDTO;

public interface PersonMapper {
    /**
     * Mapper to model person model.
     *
     * @param item the item
     * @return the person model
     */
    PersonModel mapperToModel(final ObjectItemResponseDTO item);
    /**
     * Mapper to model person model.
     *
     * @param notice the item
     * @return the person model
     */
    PersonModel mapperToModel(final NoticeResponseDTO notice);
}
