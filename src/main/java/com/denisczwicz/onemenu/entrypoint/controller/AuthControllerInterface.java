package com.denisczwicz.onemenu.entrypoint.controller;

import com.denisczwicz.onemenu.entrypoint.dtos.request.CredentialsRequestDTO;
import com.denisczwicz.onemenu.entrypoint.dtos.response.UserValidationResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;


public interface AuthControllerInterface {

    @Operation(summary = "Authenticate User - validates user credentials for authentication.")
    ResponseEntity<UserValidationResponseDTO> authenticate(@RequestBody CredentialsRequestDTO loginRequest);
}
