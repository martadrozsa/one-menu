package com.denisczwicz.onemenu.application.usecase.impl;

import com.denisczwicz.onemenu.application.port.UserGatewayPort;
import com.denisczwicz.onemenu.application.usecase.UpdateUserUseCase;
import com.denisczwicz.onemenu.domain.model.AddressModel;
import com.denisczwicz.onemenu.domain.model.UserModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UpdateUserUseCaseImpl implements UpdateUserUseCase {

    private final UserGatewayPort userGatewayPort;

    @Override
    public UserModel update(UserModel user, Long id) {
        return userGatewayPort.updateUser(user, id);
    }
}
