package com.pablo.user_service.services;

import com.pablo.user_service.dtos.UserRegisterDto;
import com.pablo.user_service.entities.UserEntity;
import com.pablo.user_service.repositories.UserRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    public AuthenticationService(UserRepository userRepository
            , PasswordEncoder passwordEncoder
            , AuthenticationManager authenticationManager) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
    }

    public UserEntity signup(UserRegisterDto input){
        return null;
    }
}
