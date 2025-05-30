package com.denisczwicz.onemenu.entrypoint.dtos.request;

import lombok.Builder;

@Builder(toBuilder = true)
public record CredentialsRequestDTO(
    String login,
    String password
) {
}
