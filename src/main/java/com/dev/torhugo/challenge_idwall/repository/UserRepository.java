package com.dev.torhugo.challenge_idwall.repository;

import com.dev.torhugo.challenge_idwall.lib.data.domain.user.UserModel;

import java.util.List;
import java.util.Optional;

public interface UserRepository {

    /**
     * Find by email user model.
     *
     * @param userEmail
     * @return {@link UserModel}
     */
    Optional<UserModel> findByEmail(final String userEmail);

    /**
     * Save to user in the database.
     *
     * @param user the user
     */
    void save(final UserModel user);

    /**
     * Find by id user model.
     *
     * @param userId the user id
     * @return the user model
     */
    UserModel findById(final Long userId);
}
