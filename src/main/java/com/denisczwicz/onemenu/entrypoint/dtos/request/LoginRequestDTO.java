package com.denisczwicz.onemenu.entrypoint.dtos.request;

import lombok.Builder;

@Builder
public record LoginRequestDTO(
    String login,
    String password
) {
}
