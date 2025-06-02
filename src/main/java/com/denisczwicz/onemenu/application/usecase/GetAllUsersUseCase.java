package com.denisczwicz.onemenu.application.usecase;

import com.denisczwicz.onemenu.domain.model.UserModel;

import java.util.List;

/**
 * GetAllUsersUseCase is an interface that defines the contract for retrieving all users.
 * It provides a method to get a list of all UserModel objects.
 */
public interface GetAllUsersUseCase {

    List<UserModel> getAllUsers();
}
