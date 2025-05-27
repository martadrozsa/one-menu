package com.denisczwicz.onemenu.entrypoint.controller;

import com.denisczwicz.onemenu.application.usecase.ValidateUserCredentialsUseCase;
import com.denisczwicz.onemenu.entrypoint.dtos.request.LoginRequestDTO;
import com.denisczwicz.onemenu.entrypoint.dtos.response.UserValidationResponseDTO;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/auth")
public class AuthController {

    private final ValidateUserCredentialsUseCase validateUserCredentialsUseCase;

    @PostMapping("/login")
    public ResponseEntity<UserValidationResponseDTO> login(@RequestBody LoginRequestDTO loginRequest) {
        boolean isValid = validateUserCredentialsUseCase.validate(loginRequest.login(), loginRequest.password());

        if (isValid) {
            return ResponseEntity.ok(new UserValidationResponseDTO(true, "Authenticated User"));
        } else {
            return ResponseEntity.status(401).body(new UserValidationResponseDTO(false, "Invalid Credentials"));
        }
    }
}
