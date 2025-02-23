package com.pablo.user_service.services;

import com.pablo.user_service.entities.UserEntity;
import com.pablo.user_service.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public List<UserEntity> allUsers() {
        return userRepository.findAll();
    }
}
