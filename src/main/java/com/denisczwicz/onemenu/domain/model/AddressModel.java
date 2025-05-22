package com.denisczwicz.onemenu.domain.model;

public record AddressModel(
        Long id,
        String street,
        String number,
        String city,
        String state,
        String country,
        String postalCode
) { }
