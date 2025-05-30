package com.denisczwicz.onemenu.domain.enums;

public enum RoleType {

    ADMIN("ADMIN"),
    USER("USER");

    private final String value;

    RoleType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
