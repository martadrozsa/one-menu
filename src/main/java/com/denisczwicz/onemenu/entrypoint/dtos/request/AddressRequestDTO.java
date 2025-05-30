package com.denisczwicz.onemenu.entrypoint.dtos.request;

import lombok.Builder;

@Builder(toBuilder = true)
public record AddressRequestDTO(
        String street,
        String number,
        String city,
        String state,
        String country,
        String postalCode
) { }
