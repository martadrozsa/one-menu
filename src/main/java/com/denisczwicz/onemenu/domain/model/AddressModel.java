package com.denisczwicz.onemenu.domain.model;

import lombok.Builder;

@Builder(toBuilder = true)
public record AddressModel(
        Long id,
        String street,
        String number,
        String city,
        String state,
        String country,
        String postalCode
) { }