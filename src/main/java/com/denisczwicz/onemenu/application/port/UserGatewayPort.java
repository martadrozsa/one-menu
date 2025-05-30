package com.denisczwicz.onemenu.application.port;

import com.denisczwicz.onemenu.domain.model.UserModel;

import java.util.List;

public interface UserGatewayPort {

    UserModel createUser(UserModel userModel);

    List<UserModel> getAllUsers();

    UserModel getUserById(Long id);

    UserModel updateProfileUser(UserModel userModel, Long id);

    void deleteUser(Long id);

    UserModel updateCredentials(UserModel userModel, Long id);

}
