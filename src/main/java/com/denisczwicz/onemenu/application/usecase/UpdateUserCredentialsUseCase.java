package com.denisczwicz.onemenu.application.usecase;

import com.denisczwicz.onemenu.domain.model.UserModel;

public interface UpdateUserCredentialsUseCase {

    UserModel updateCredentials(UserModel userModel, Long id);

}

