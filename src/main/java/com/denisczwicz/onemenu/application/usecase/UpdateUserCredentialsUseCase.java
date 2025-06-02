package com.denisczwicz.onemenu.application.usecase;

import com.denisczwicz.onemenu.domain.model.UserModel;

/**
 * UpdateUserCredentialsUseCase is an interface that defines the contract for updating user credentials.
 * It provides a method to update the credentials of a user identified by their ID.
 */
public interface UpdateUserCredentialsUseCase {

    UserModel updateCredentials(UserModel userModel, Long id);

}

