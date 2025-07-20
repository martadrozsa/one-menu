package com.denisczwicz.onemenu.entrypoint.controller;

import com.denisczwicz.onemenu.entrypoint.dtos.request.CreateUserRequestDTO;
import com.denisczwicz.onemenu.entrypoint.dtos.request.UpdatePasswordRequestDTO;
import com.denisczwicz.onemenu.entrypoint.dtos.request.UpdateUserProfileRequestDTO;
import com.denisczwicz.onemenu.entrypoint.dtos.response.UserResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Set;

public interface UserControllerInterface {

    @Operation(summary = "Create User - registers a new user in the system.")
    ResponseEntity<UserResponseDTO> createUser(@RequestBody @Valid CreateUserRequestDTO createUserRequestDTO);

    @Operation(summary = "Get All Users - retrieves a list of all users in the system.")
    ResponseEntity<List<UserResponseDTO>> getAllUsers();

    @Operation(summary = "Get User by ID - retrieves a user's information based on their unique identifier.")
    ResponseEntity<UserResponseDTO> getUserById(@PathVariable Long id);

    @Operation(summary = "Update User Profile - updates the profile information of a user by their ID.")
    ResponseEntity<UserResponseDTO> updateUser(@PathVariable Long id, @RequestBody @Valid UpdateUserProfileRequestDTO updateUserRequestDTO);

    @Operation(summary = "Delete User - deletes a user from the system by their ID.")
    ResponseEntity<UserResponseDTO> deleteUser(@PathVariable Long id);

    @Operation(summary = "Update User Password - updates the credentials of a user by their ID.")
    ResponseEntity<UserResponseDTO> updateUserPassword(@PathVariable Long id, @RequestBody @Valid UpdatePasswordRequestDTO updatePasswordRequestDTO);
}
