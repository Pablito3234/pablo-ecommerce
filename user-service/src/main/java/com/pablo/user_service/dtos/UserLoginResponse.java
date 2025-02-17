package com.pablo.user_service.dtos;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserLoginResponse {
    private String token;

    private long expirationTime;

    public UserLoginResponse(String token, long expirationTime) {
        this.token = token;
        this.expirationTime = expirationTime;
    }
}
