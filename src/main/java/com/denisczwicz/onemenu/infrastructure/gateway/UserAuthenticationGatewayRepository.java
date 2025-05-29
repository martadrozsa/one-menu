package com.denisczwicz.onemenu.infrastructure.gateway;

import com.denisczwicz.onemenu.application.port.UserAuthenticationGatewayPort;
import com.denisczwicz.onemenu.infrastructure.database.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@RequiredArgsConstructor
@Component
public class UserAuthenticationGatewayRepository implements UserAuthenticationGatewayPort {

    private final UserRepository userRepository;

    @Override
    public boolean validateCredentials(String login, String password) {
    try {
        return userRepository.existsByLoginAndPassword(login, password);
        } catch (Exception e) {
            log.error("Error validating credentials for user {}: {}", login, e.getMessage());
        }
        return false;
    }
}
