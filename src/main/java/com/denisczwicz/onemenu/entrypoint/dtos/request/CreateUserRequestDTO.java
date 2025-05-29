package com.denisczwicz.onemenu.entrypoint.dtos.request;

import lombok.Builder;

@Builder
public record CreateUserRequestDTO(
        String name,
        String email,
        String login,
        String password,
        AddressRequestDTO address
) {
    public CreateUserRequestDTO {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be null or blank");
        }
        if (email == null || email.isBlank()) {
            throw new IllegalArgumentException("Email cannot be null or blank");
        }
        if (password == null || password.isBlank()) {
            throw new IllegalArgumentException("Password cannot be null or blank");
        }
    }
}
