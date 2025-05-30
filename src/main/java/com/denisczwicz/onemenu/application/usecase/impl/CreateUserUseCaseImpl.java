package com.denisczwicz.onemenu.application.usecase.impl;

import com.denisczwicz.onemenu.application.port.RoleGatewayPort;
import com.denisczwicz.onemenu.application.port.UserGatewayPort;
import com.denisczwicz.onemenu.application.usecase.CreateUserUseCase;
import com.denisczwicz.onemenu.domain.exception.BadRequestException;
import com.denisczwicz.onemenu.domain.model.UserModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CreateUserUseCaseImpl implements CreateUserUseCase {

    private final UserGatewayPort userGatewayPort;
    private final RoleGatewayPort roleGatewayPort;

    @Override
    public UserModel createUser(UserModel userModel) {
        boolean allPermissionsExist = roleGatewayPort.existAllPermission(userModel.roles());
        if (!allPermissionsExist) {
            throw new BadRequestException("Some permissions do not exist");
        }

        return userGatewayPort.createUser(userModel);
    }

}
