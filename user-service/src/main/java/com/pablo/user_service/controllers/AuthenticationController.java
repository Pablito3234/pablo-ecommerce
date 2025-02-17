package com.pablo.user_service.controllers;

import com.pablo.user_service.dtos.UserLoginDto;
import com.pablo.user_service.dtos.UserLoginResponse;
import com.pablo.user_service.dtos.UserRegisterDto;
import com.pablo.user_service.entities.UserEntity;
import com.pablo.user_service.services.AuthenticationService;
import com.pablo.user_service.services.JwtService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/auth")
@RestController
public class AuthenticationController {
    private final JwtService jwtService;
    private final AuthenticationService authenticationService;

    public AuthenticationController(JwtService jwtService, AuthenticationService authenticationService) {
        this.jwtService = jwtService;
        this.authenticationService = authenticationService;
    }

    @PostMapping("/register")
    public ResponseEntity<UserEntity> register(@RequestBody UserRegisterDto input){
        UserEntity registeredUser = authenticationService.signup(input);

        return ResponseEntity.ok(registeredUser);
    }

    @PostMapping("/login")
    public ResponseEntity<UserLoginResponse> login(@RequestBody UserLoginDto input){
        UserEntity authenticatedUser = authenticationService.authenticate(input);

        String jwtToken = jwtService.generateToken(authenticatedUser);

        UserLoginResponse loginResponse = new UserLoginResponse(jwtToken, jwtService.getExpirationTime());

        return ResponseEntity.ok(loginResponse);
    }
}
