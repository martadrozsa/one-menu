package com.denisczwicz.onemenu.application.port;

import com.denisczwicz.onemenu.domain.model.UserModel;

import java.util.List;

public interface UserGatewayPort {

    void createUser(UserModel userModel);

    List<UserModel> getAllUsers();

    UserModel getUserById(Long id);

}
