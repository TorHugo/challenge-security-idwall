package com.dev.torhugo.challenge_idwall.mapper;

import com.dev.torhugo.challenge_idwall.lib.data.domain.user.UserModel;
import com.dev.torhugo.challenge_idwall.lib.data.dto.auth.RegisterRequest;

public interface UserMapper {
    /**
     * Mapping as user model.
     *
     * @param request the request
     * @return the user model
     */
    UserModel mappingToModel(final RegisterRequest request);
}
