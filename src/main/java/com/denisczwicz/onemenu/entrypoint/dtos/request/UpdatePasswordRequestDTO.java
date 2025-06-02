package com.denisczwicz.onemenu.entrypoint.dtos.request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;

@Builder(toBuilder = true)
public record UpdatePasswordRequestDTO(
        String password
) {
}
