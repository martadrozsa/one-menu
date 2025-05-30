package com.denisczwicz.onemenu.entrypoint.dtos.response;

import lombok.Builder;

@Builder(toBuilder = true)
public record AddressResponseDTO(
        String street,
        String number,
        String city,
        String state,
        String country,
        String postalCode
) { }
