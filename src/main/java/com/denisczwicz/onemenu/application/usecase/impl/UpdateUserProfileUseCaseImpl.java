package com.denisczwicz.onemenu.application.usecase.impl;

import com.denisczwicz.onemenu.application.port.UserGatewayPort;
import com.denisczwicz.onemenu.application.usecase.UpdateUserProfileUseCase;
import com.denisczwicz.onemenu.domain.exception.UserNotFoundException;
import com.denisczwicz.onemenu.domain.model.UserModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UpdateUserProfileUseCaseImpl implements UpdateUserProfileUseCase {

    private final UserGatewayPort userGatewayPort;

    @Override
    public UserModel updateProfile(UserModel user, Long id) {
        UserModel userModel = userGatewayPort.updateProfileUser(user, id);

        if (userModel == null) {
            throw new UserNotFoundException("User not found with id: " + id);
        }

        return userModel;
    }
}
