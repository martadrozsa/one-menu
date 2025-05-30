package com.denisczwicz.onemenu.entrypoint.dtos.response;

import lombok.Builder;

@Builder(toBuilder = true)
public record UserValidationResponseDTO(
    boolean valid,
    String message
) {
}
