package com.denisczwicz.onemenu.domain.model;

import lombok.Builder;

import java.time.LocalDateTime;
import java.util.List;

@Builder(toBuilder = true)
public record UserModel(
        String name,
        String email,
        String login,
        String password,
        AddressModel address
        //private UserRole role;

) { }
