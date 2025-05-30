package com.denisczwicz.onemenu.entrypoint.dtos.response;

import lombok.Builder;

import java.util.Set;

@Builder(toBuilder = true)
public record UserResponseDTO(
        String name,
        String email,
        String login,
        String password,
        AddressResponseDTO address,
        Set<String> roles
) { }