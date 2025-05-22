package com.denisczwicz.onemenu.application.usecase.impl;

import com.denisczwicz.onemenu.application.usecase.CreateUserUseCase;
import com.denisczwicz.onemenu.domain.model.UserModel;
import org.springframework.stereotype.Service;

@Service
public class CreateUserUseCaseImpl implements CreateUserUseCase {


    @Override
    public void createUser(UserModel userModel) {
        return;
    }

}
