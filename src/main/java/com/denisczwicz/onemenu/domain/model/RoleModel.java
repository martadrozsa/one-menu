package com.denisczwicz.onemenu.domain.model;

import lombok.Builder;

@Builder(toBuilder = true)
public record RoleModel(String permission
) { }