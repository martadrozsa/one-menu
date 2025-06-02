package com.denisczwicz.onemenu.application.usecase;

/**
 * ValidateUserCredentialsUseCase is an interface that defines the contract for validating user credentials.
 * It provides a method to validate the credentials of a user identified by their login and password.
 */
public interface ValidateUserCredentialsUseCase {

    boolean validate(String login, String password);
}
