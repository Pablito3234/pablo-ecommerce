package com.pablo.user_service.dtos;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserLoginResponse {
    private String token;

    private long expirationTime;
}
