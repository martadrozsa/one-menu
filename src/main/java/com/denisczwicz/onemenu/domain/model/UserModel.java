package com.denisczwicz.onemenu.domain.model;

import lombok.Builder;

import java.util.Set;

@Builder(toBuilder = true)
public record UserModel(
        Long id,
        String name,
        String email,
        String login,
        String password,
        AddressModel address,
        Set<String> roles
) { }
