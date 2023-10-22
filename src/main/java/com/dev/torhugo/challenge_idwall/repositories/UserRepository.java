package com.dev.torhugo.challenge_idwall.repositories;

import com.dev.torhugo.challenge_idwall.lib.data.domain.user.UserModel;

public interface UserRepository {

    /**
     * Find by email user model.
     *
     * @param userEmail the user email
     * @return the user model
     */
    UserModel findByEmail(final String userEmail);

    /**
     * Save to user in the database.
     *
     * @param user the user
     */
    void save(final UserModel user);
}
