package com.denisczwicz.onemenu.application.usecase.impl;

import com.denisczwicz.onemenu.application.port.UserGatewayPort;
import com.denisczwicz.onemenu.application.usecase.GetUserUseCase;
import com.denisczwicz.onemenu.domain.model.UserModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@RequiredArgsConstructor
@Service
public class GetUserUseCaseImpl implements GetUserUseCase {

    private final UserGatewayPort userGatewayPort;

    @Override
    public UserModel getUserById(Long id) {
        return userGatewayPort.getUserById(id);
    }
}
