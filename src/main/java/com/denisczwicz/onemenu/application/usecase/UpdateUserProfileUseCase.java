package com.denisczwicz.onemenu.application.usecase;

import com.denisczwicz.onemenu.domain.model.UserModel;

/**
 * UpdateUserProfileUseCase is an interface that defines the contract for updating a user's profile.
 * It provides a method to update the profile of a user identified by their ID.
 */
public interface UpdateUserProfileUseCase {

    UserModel updateProfile(UserModel userModel, Long id);

}

