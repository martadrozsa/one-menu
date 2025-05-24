package com.denisczwicz.onemenu.entrypoint.dtos.response;

import com.denisczwicz.onemenu.entrypoint.dtos.request.AddressRequestDTO;
import lombok.Builder;

@Builder
public record UserResponseDTO(
        String name,
        String email,
        String login,
        String password,
        AddressRequestDTO address
) {

}