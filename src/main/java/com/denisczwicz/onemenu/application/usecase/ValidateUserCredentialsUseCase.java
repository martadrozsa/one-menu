package com.denisczwicz.onemenu.application.usecase;

public interface ValidateUserCredentialsUseCase {

    boolean validate(String login, String password);
}
