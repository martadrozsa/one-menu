package com.denisczwicz.onemenu.entrypoint.controller;

import com.denisczwicz.onemenu.application.usecase.CreateUserUseCase;
import com.denisczwicz.onemenu.entrypoint.dtos.UserRequestDTO;
import com.denisczwicz.onemenu.entrypoint.mapper.UserDTOMapper;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
public class UserController {

    private final CreateUserUseCase createUserUseCase;
    private final UserDTOMapper userDTOMapper;


    @PostMapping
    public void createUser(@RequestBody UserRequestDTO userRequest) {
        createUserUseCase.createUser(userDTOMapper.toModel(userRequest));
    }




}
