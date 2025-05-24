package com.denisczwicz.onemenu.entrypoint.dtos;

import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record UserRequestDTO(
        String name,
        String email,
        String login,
        String password,
        LocalDateTime lastUpdate,
        AddressRequestDTO address
) {
    public UserRequestDTO {
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
