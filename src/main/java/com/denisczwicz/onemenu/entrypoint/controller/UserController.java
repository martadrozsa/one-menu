package com.denisczwicz.onemenu.entrypoint.controller;

import com.denisczwicz.onemenu.application.usecase.CreateUserUseCase;
import com.denisczwicz.onemenu.application.usecase.GetAllUsersUseCase;
import com.denisczwicz.onemenu.application.usecase.GetUserUseCase;
import com.denisczwicz.onemenu.entrypoint.dtos.request.UserRequestDTO;
import com.denisczwicz.onemenu.entrypoint.dtos.response.UserResponseDTO;
import com.denisczwicz.onemenu.entrypoint.mapper.UserDTOMapper;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
public class UserController {

    private final CreateUserUseCase createUserUseCase;
    private final GetAllUsersUseCase getAllUsersUseCase;
    private final GetUserUseCase getUserUseCase;
    private final UserDTOMapper userDTOMapper;


    @PostMapping
    public void createUser(@RequestBody UserRequestDTO userRequest) {
        createUserUseCase.createUser(userDTOMapper.toModel(userRequest));
    }

    @GetMapping("/users")
    public List<UserResponseDTO> getAllUsers() {

        return getAllUsersUseCase.getAllUsers()
                .stream()
                .map(userDTOMapper::toResponseDTO)
                .toList();
    }

    @GetMapping("/users/{id}")
    public UserResponseDTO getUserById(@PathVariable Long id) {
        return userDTOMapper.toResponseDTO(getUserUseCase.getUserById(id));
    }


}
