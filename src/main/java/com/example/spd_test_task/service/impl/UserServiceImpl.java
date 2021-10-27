package com.example.spd_test_task.service.impl;

import com.example.spd_test_task.dto.UserDTO;
import com.example.spd_test_task.mappers.UserMapper;
import com.example.spd_test_task.model.User;
import com.example.spd_test_task.repository.UserRepository;
import com.example.spd_test_task.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.DependsOn;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public UserDTO save(UserDTO userDTO) {
        userDTO.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        User save = userRepository.save(userMapper.userDtoToUser(userDTO));

        return userMapper.userToUserDto(save);
    }

    @Override
    public UserDTO findByPhoneNumber(String phoneNumber) {
        return null;
    }
}
