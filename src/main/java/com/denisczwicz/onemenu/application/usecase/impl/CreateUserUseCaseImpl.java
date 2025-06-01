package com.denisczwicz.onemenu.application.usecase.impl;

import com.denisczwicz.onemenu.application.port.RoleGatewayPort;
import com.denisczwicz.onemenu.application.port.UserGatewayPort;
import com.denisczwicz.onemenu.application.usecase.CreateUserUseCase;
import com.denisczwicz.onemenu.domain.exception.BadRequestException;
import com.denisczwicz.onemenu.domain.exception.UserAlreadyExistsException;
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
        if (userModel.roles() == null || userModel.roles().isEmpty()) {
            throw new BadRequestException("User must have at least one role");
        }

        if (userGatewayPort.existsByLogin(userModel.login())) {
            throw new UserAlreadyExistsException("Login already exists");
        }

        if (userGatewayPort.existsByEmail(userModel.email())) {
            throw new UserAlreadyExistsException("Email already exists");
        }

        boolean allPermissionsExist = roleGatewayPort.existAllPermission(userModel.roles());
        if (!allPermissionsExist) {
            throw new BadRequestException("Some permissions do not exist");
        }

        return userGatewayPort.createUser(userModel);
    }

}
