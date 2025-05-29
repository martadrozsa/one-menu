package com.denisczwicz.onemenu.entrypoint.dtos.request;

import lombok.Builder;

@Builder
public record UpdateUserProfileRequestDTO(
        String name,
        String email,
        AddressRequestDTO address
) {
    public UpdateUserProfileRequestDTO {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be null or blank");
        }
        if (email == null || email.isBlank()) {
            throw new IllegalArgumentException("Email cannot be null or blank");
        }
    }
}
