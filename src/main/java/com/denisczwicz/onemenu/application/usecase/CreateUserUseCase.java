package com.denisczwicz.onemenu.application.usecase;

import com.denisczwicz.onemenu.domain.model.UserModel;
import org.springframework.stereotype.Service;

public interface CreateUserUseCase {

    void createUser(UserModel userModel);

}
