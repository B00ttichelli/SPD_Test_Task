package com.example.spd_test_task.service.impl;

import com.example.spd_test_task.dto.UserDTO;
import com.example.spd_test_task.repository.UserRepository;
import com.example.spd_test_task.service.UserService;
import org.springframework.context.annotation.DependsOn;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
@DependsOn("passwordEncoder")
public class UserServiceImpl implements UserService {

    private  PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    public UserServiceImpl( UserRepository userRepository) {

        this.userRepository = userRepository;
    }

    @Override
    public UserDTO save(UserDTO userDTO) {
        return null;
    }

    @Override
    public UserDTO findByPhoneNumber(String phoneNumber) {
        return null;
    }
}
