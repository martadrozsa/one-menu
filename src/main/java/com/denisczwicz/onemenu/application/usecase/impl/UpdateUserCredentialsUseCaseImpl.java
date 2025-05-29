package com.denisczwicz.onemenu.application.usecase.impl;

import com.denisczwicz.onemenu.application.port.UserGatewayPort;
import com.denisczwicz.onemenu.application.usecase.UpdateUserCredentialsUseCase;
import com.denisczwicz.onemenu.domain.model.UserModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UpdateUserCredentialsUseCaseImpl implements UpdateUserCredentialsUseCase {

    private final UserGatewayPort userGatewayPort;

    @Override
    public UserModel updateCredentials(UserModel user, Long id) {
        return userGatewayPort.updateCredentials(user, id);
    }
}
