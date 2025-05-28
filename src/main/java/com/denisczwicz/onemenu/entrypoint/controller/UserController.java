package com.denisczwicz.onemenu.entrypoint.controller;

import com.denisczwicz.onemenu.application.usecase.CreateUserUseCase;
import com.denisczwicz.onemenu.application.usecase.DeleteUserUseCase;
import com.denisczwicz.onemenu.application.usecase.GetAllUsersUseCase;
import com.denisczwicz.onemenu.application.usecase.GetUserUseCase;
import com.denisczwicz.onemenu.application.usecase.UpdateUserUseCase;
import com.denisczwicz.onemenu.domain.model.UserModel;
import com.denisczwicz.onemenu.entrypoint.dtos.request.UserRequestDTO;
import com.denisczwicz.onemenu.entrypoint.dtos.response.UserResponseDTO;
import com.denisczwicz.onemenu.entrypoint.mapper.UserDTOMapper;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
public class UserController {

    private final CreateUserUseCase createUserUseCase;
    private final GetAllUsersUseCase getAllUsersUseCase;
    private final GetUserUseCase getUserUseCase;
    private final UpdateUserUseCase updateUserUseCase;
    private final DeleteUserUseCase deleteUserUseCase;
    private final UserDTOMapper userDTOMapper;


    @PostMapping("/users")
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

    @PutMapping("/users/{id}")
    public ResponseEntity<UserResponseDTO> updateUser(@PathVariable Long id, @RequestBody UserRequestDTO userRequest) {
        if (id == null) {
            return ResponseEntity.notFound().build();
        }

        updateUserUseCase.update(userDTOMapper.toModel(userRequest), id);
        UserResponseDTO userResponse = userDTOMapper.toResponseDTO(getUserUseCase.getUserById(id));

        return ResponseEntity.ok(userResponse);
    }

    @DeleteMapping("users/{id}")
    public ResponseEntity<UserResponseDTO> deleteUser(@PathVariable Long id) {
        UserModel userModel = getUserUseCase.getUserById(id);
        if (userModel == null) {
            return ResponseEntity.notFound().build();
        }

        deleteUserUseCase.deleteUser(id);
        return ResponseEntity.ok(userDTOMapper.toResponseDTO(userModel));
    }


}
