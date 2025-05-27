package com.denisczwicz.onemenu.entrypoint.dtos.response;

public record UserValidationResponseDTO(
    boolean valid,
    String message
) {
}
