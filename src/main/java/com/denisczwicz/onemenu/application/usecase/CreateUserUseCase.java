package com.denisczwicz.onemenu.application.usecase;

import com.denisczwicz.onemenu.domain.model.UserModel;

/**
 * CreateUserUseCase is an interface that defines the contract for creating a user.
 * It provides a method to create a user with the given UserModel.
 */
public interface CreateUserUseCase {

    UserModel createUser(UserModel userModel);

}
