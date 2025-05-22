package com.denisczwicz.onemenu.application.port;

import com.denisczwicz.onemenu.domain.model.UserModel;

public interface UserGatewayPort {

    void createUser(UserModel userModel);

}
