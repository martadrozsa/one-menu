package com.denisczwicz.onemenu.application.usecase;

import com.denisczwicz.onemenu.domain.model.UserModel;

public interface UpdateUserProfileUseCase {

    UserModel updateProfile(UserModel userModel, Long id);

}

