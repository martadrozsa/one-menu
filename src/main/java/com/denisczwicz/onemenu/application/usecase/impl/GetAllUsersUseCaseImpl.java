package com.denisczwicz.onemenu.application.usecase.impl;

import com.denisczwicz.onemenu.application.port.UserGatewayPort;
import com.denisczwicz.onemenu.application.usecase.GetAllUsersUseCase;
import com.denisczwicz.onemenu.domain.model.UserModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class GetAllUsersUseCaseImpl implements GetAllUsersUseCase {

    private final UserGatewayPort userGatewayPort;

    @Override
    public List<UserModel> getAllUsers() {
        return userGatewayPort.getAllUsers();
    }
}
