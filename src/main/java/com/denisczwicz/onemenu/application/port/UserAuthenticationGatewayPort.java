package com.denisczwicz.onemenu.application.port;

public interface UserAuthenticationGatewayPort {

    boolean validateCredentials(String login, String password);

}
