package com.denisczwicz.onemenu.application.port;

import com.denisczwicz.onemenu.domain.model.UserModel;

import java.util.List;

/**
 * UserGatewayPort is an interface that defines the contract for user-related operations.
 * It provides methods to create, retrieve, update, and delete users, as well as check for user existence by login and email.
 */
public interface UserGatewayPort {

    UserModel createUser(UserModel userModel);

    List<UserModel> getAllUsers();

    UserModel getUserById(Long id);

    UserModel updateUserProfile(UserModel userModel, Long id);

    void deleteUser(Long id);

    UserModel updateCredentials(UserModel userModel, Long id);

    boolean existsByLogin(String login);

    boolean existsByEmail(String email);
}
