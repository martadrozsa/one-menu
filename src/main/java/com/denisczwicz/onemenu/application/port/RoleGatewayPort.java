package com.denisczwicz.onemenu.application.port;

import java.util.Set;

/**
 * RoleGatewayPort is an interface that defines the contract for role-related operations.
 * It provides methods to check if a set of permissions exists.
 */
public interface RoleGatewayPort {

    boolean existAllPermission(Set<String> permissions);

}
