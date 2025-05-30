package com.denisczwicz.onemenu.infrastructure.gateway;

import com.denisczwicz.onemenu.application.port.RoleGatewayPort;
import com.denisczwicz.onemenu.infrastructure.database.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Set;

@RequiredArgsConstructor
@Component
public class RoleGatewayRepository implements RoleGatewayPort {

    private final RoleRepository roleRepository;

    @Override
    public boolean existAllPermission(Set<String> permissions) {
        Long existingPermission = roleRepository.countByPermissionIn(permissions);

        if (existingPermission != permissions.size()) {
            return false;
        }

        return true;
    }
}
