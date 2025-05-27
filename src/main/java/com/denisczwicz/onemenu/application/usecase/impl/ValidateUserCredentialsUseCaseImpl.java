package com.denisczwicz.onemenu.application.usecase.impl;

import com.denisczwicz.onemenu.application.usecase.ValidateUserCredentialsUseCase;
import com.denisczwicz.onemenu.infrastructure.gateway.UserAuthenticationGatewayRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ValidateUserCredentialsUseCaseImpl implements ValidateUserCredentialsUseCase {

    private final UserAuthenticationGatewayRepository userAuthenticationGatewayRepository;

    @Override
    public boolean validate(String login, String password) {
        return userAuthenticationGatewayRepository.validateCredentials(login, password);
    }
}
