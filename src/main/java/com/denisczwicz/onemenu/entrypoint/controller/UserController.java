package com.denisczwicz.onemenu.entrypoint.controller;

import com.denisczwicz.onemenu.application.usecase.CreateUserUseCase;
import com.denisczwicz.onemenu.application.usecase.DeleteUserUseCase;
import com.denisczwicz.onemenu.application.usecase.GetAllUsersUseCase;
import com.denisczwicz.onemenu.application.usecase.GetUserUseCase;
import com.denisczwicz.onemenu.application.usecase.UpdateUserCredentialsUseCase;
import com.denisczwicz.onemenu.application.usecase.UpdateUserProfileUseCase;
import com.denisczwicz.onemenu.domain.model.UserModel;
import com.denisczwicz.onemenu.entrypoint.dtos.request.CreateUserRequestDTO;
import com.denisczwicz.onemenu.entrypoint.dtos.request.CredentialsRequestDTO;
import com.denisczwicz.onemenu.entrypoint.dtos.request.UpdateUserProfileRequestDTO;
import com.denisczwicz.onemenu.entrypoint.dtos.response.UserResponseDTO;
import com.denisczwicz.onemenu.entrypoint.mapper.UserDTOMapper;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController()
@RequestMapping("/users")
public class UserController {

    private final CreateUserUseCase createUserUseCase;
    private final GetAllUsersUseCase getAllUsersUseCase;
    private final GetUserUseCase getUserUseCase;
    private final UpdateUserProfileUseCase updateUserProfileUseCase;
    private final DeleteUserUseCase deleteUserUseCase;
    private final UpdateUserCredentialsUseCase updateUserCredentialsUseCase;
    private final UserDTOMapper userDTOMapper;


    @PostMapping
    public ResponseEntity<UserResponseDTO> createUser(
            @RequestBody @Valid CreateUserRequestDTO createUserRequestDTO
    ) {
        UserModel userDTOMapperModel = userDTOMapper.toModel(createUserRequestDTO);
        createUserUseCase.createUser(userDTOMapperModel);

        UserResponseDTO userResponseDTO = userDTOMapper.toResponseDTO(userDTOMapperModel);

        return ResponseEntity.ok(userResponseDTO);
    }

    @GetMapping
    public List<UserResponseDTO> getAllUsers() {

        return getAllUsersUseCase.getAllUsers()
                .stream()
                .map(userDTOMapper::toResponseDTO)
                .toList();
    }

    @GetMapping("/{id}")
    public UserResponseDTO getUserById(
            @PathVariable Long id
    ) {
        return userDTOMapper.toResponseDTO(getUserUseCase.getUserById(id));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<UserResponseDTO> updateUser(
            @PathVariable Long id,
            @RequestBody UpdateUserProfileRequestDTO updateUserRequestDTO
    ) {
        if (id == null) {
            return ResponseEntity.notFound().build();
        }

        UserModel updatedUser = updateUserProfileUseCase.updateProfile(userDTOMapper.toModel(updateUserRequestDTO), id);

        if (updatedUser == null) {
            return ResponseEntity.notFound().build();
        }

        UserResponseDTO userResponseDTO = userDTOMapper.toResponseDTO(updatedUser);

        return ResponseEntity.ok(userResponseDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<UserResponseDTO> deleteUser(@PathVariable Long id) {
        UserModel userModel = getUserUseCase.getUserById(id);
        if (userModel == null) {
            return ResponseEntity.notFound().build();
        }

        deleteUserUseCase.deleteUser(id);
        return ResponseEntity.ok(userDTOMapper.toResponseDTO(userModel));
    }

    @PatchMapping("/{id}/credentials")
    public ResponseEntity<UserResponseDTO> updateUserCredentials(
            @PathVariable Long id,
            @RequestBody CredentialsRequestDTO credentialsRequestDTO
    ) {
        if (id == null) {
            return ResponseEntity.notFound().build();
        }

        UserModel updatedUserCredentials = updateUserCredentialsUseCase.updateCredentials(
                userDTOMapper.toModel(credentialsRequestDTO), id);

        if (updatedUserCredentials == null) {
            return ResponseEntity.notFound().build();
        }

        UserResponseDTO userResponseDTO = userDTOMapper.toResponseDTO(updatedUserCredentials);

        return ResponseEntity.ok(userResponseDTO);
    }
}
