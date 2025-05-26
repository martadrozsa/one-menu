package com.denisczwicz.onemenu.application.usecase;

import com.denisczwicz.onemenu.domain.model.UserModel;

public interface UpdateUserUseCase {

    UserModel update(UserModel userModel, Long id);

}
