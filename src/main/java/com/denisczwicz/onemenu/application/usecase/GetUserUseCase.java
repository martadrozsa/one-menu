package com.denisczwicz.onemenu.application.usecase;

import com.denisczwicz.onemenu.domain.model.UserModel;

/**
 * GetUserUseCase is an interface that defines the contract for retrieving a user by their ID.
 * It provides a method to get a UserModel object based on the provided user ID.
 */
public interface GetUserUseCase {

    UserModel getUserById(Long id);
}
