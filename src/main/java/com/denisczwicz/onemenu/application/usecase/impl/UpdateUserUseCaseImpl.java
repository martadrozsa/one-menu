package com.denisczwicz.onemenu.application.usecase.impl;

import com.denisczwicz.onemenu.application.port.UserGatewayPort;
import com.denisczwicz.onemenu.application.usecase.UpdateUserUseCase;
import com.denisczwicz.onemenu.domain.model.UserModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UpdateUserUseCaseImpl implements UpdateUserUseCase {

    private final UserGatewayPort userGatewayPort;

    @Override
    public UserModel update(UserModel userModel, Long id) {
        UserModel userById = userGatewayPort.getUserById(id);

        userGatewayPort.updateUser(userModel, id);
        return userById;
    }
}
