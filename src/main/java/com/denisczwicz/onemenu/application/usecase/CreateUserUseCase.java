package com.denisczwicz.onemenu.application.usecase;

import com.denisczwicz.onemenu.domain.model.UserModel;

public interface CreateUserUseCase {

    UserModel createUser(UserModel userModel);

}
