package com.denisczwicz.onemenu.entrypoint.dtos;

import lombok.Builder;

@Builder
public record AddressRequestDTO(
        String street,
        String number,
        String city,
        String state,
        String country,
        String postalCode
) { }
