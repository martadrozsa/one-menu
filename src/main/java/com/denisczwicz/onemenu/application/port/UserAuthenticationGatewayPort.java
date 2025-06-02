package com.denisczwicz.onemenu.application.port;

/**
 * UserAuthenticationGatewayPort is an interface that defines the contract for user authentication operations.
 * It provides methods to validate user credentials.
 */
public interface UserAuthenticationGatewayPort {

    boolean validateCredentials(String login, String password);

}
