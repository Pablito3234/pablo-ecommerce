package com.pablo.user_service.entities;
import com.fasterxml.jackson.annotation.JsonValue;

public enum Role {
    ADMIN("admin"),
    USER("user");

    private final String value;

    Role(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return value;
    }
}