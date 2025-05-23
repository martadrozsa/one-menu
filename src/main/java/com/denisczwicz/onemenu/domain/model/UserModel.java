package com.denisczwicz.onemenu.domain.model;

public record UserModel(
        String name,
        String email,
        String login,
        String password,
        String lastUpdate,
        AddressModel address
        //private UserRole role;

) { }
