package com.denisczwicz.onemenu.application.port;

import java.util.Set;

public interface RoleGatewayPort {

    boolean existAllPermission(Set<String> permissions);

}
