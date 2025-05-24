package com.denisczwicz.onemenu.domain.model;

import java.time.LocalDateTime;
import java.util.List;

public record UserModel(
        String name,
        String email,
        String login,
        String password,
        LocalDateTime lastUpdate,
        AddressModel address
        //private UserRole role;

) { }
