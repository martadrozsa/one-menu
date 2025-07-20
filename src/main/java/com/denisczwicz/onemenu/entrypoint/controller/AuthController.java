package com.denisczwicz.onemenu.entrypoint.controller;

import com.denisczwicz.onemenu.application.usecase.ValidateUserCredentialsUseCase;
import com.denisczwicz.onemenu.entrypoint.dtos.request.CredentialsRequestDTO;
import com.denisczwicz.onemenu.entrypoint.dtos.response.UserValidationResponseDTO;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * AuthController is responsible for handling authentication requests.
 * It provides an endpoint to validate user credentials.
 */
@AllArgsConstructor
@RestController
public class AuthController implements AuthControllerInterface {

    private final ValidateUserCredentialsUseCase validateUserCredentialsUseCase;

    @Override
    @PostMapping("/authenticate")
    public ResponseEntity<UserValidationResponseDTO> authenticate(
            @RequestBody CredentialsRequestDTO loginRequest
    ) {
        boolean isValid = validateUserCredentialsUseCase.validate(loginRequest.login(), loginRequest.password());
        return ResponseEntity
                .status(isValid ? 200 : 401)
                .body(new UserValidationResponseDTO(
                        isValid, isValid ? "Authenticated User" : "Invalid Credentials")
                );
    }
}
