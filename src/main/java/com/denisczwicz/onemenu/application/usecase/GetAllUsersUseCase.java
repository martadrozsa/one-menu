package com.denisczwicz.onemenu.application.usecase;

import com.denisczwicz.onemenu.domain.model.UserModel;

import java.util.List;

public interface GetAllUsersUseCase {

    List<UserModel> getAllUsers();
}
