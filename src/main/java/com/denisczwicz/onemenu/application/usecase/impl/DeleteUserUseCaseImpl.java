package com.denisczwicz.onemenu.application.usecase.impl;

import com.denisczwicz.onemenu.application.port.AddressGatewayPort;
import com.denisczwicz.onemenu.application.port.UserGatewayPort;
import com.denisczwicz.onemenu.application.usecase.DeleteUserUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class DeleteUserUseCaseImpl implements DeleteUserUseCase {

    private final UserGatewayPort userGatewayPort;


    @Override
    public void deleteUser(Long id) {
        userGatewayPort.getUserById(id);
        userGatewayPort.deleteUser(id);

    }
}
